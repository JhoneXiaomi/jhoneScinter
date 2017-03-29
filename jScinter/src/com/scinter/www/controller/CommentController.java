package com.scinter.www.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scinter.www.dao.CommentMapper;
import com.scinter.www.dao.SysLogMapper;
import com.scinter.www.model.Comment;
import com.scinter.www.model.CommentExample;
import com.scinter.www.model.CommentExample.Criteria;
import com.scinter.www.model.SysLog;
import com.scinter.www.util.JsonPrintUtil;
import com.scinter.www.util.Page;
import com.scinter.www.util.SysLogUtil;
import com.scinter.www.util.TableName;

@Controller
@RequestMapping("admin")
public class CommentController extends BaseController {

	private Logger logger = Logger.getLogger(CommentController.class);
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired 
	private SysLogMapper sysLogMapper;
	/**
	 * 实现留言评论模块页面的数据列表展示
	 * @param page       当前页码 
	 * @param rows		  页容量
	 * @param response   用于动态响应客户端请示,包含了JSON 格式的返回数据,提供pageSave 页面的显示
	 */
	@RequestMapping("listPageToJson")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void listPageToJson(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpSession session,HttpServletResponse response) {
		
		//分页条件查询
		CommentExample ce = new CommentExample();
		Criteria criteria = ce.createCriteria();
		//非删除状态
		criteria.andStatusNotEqualTo(3);
		
		int totalNums = commentMapper.countByExample(ce);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		ce.setPage(p);
		ce.setOrderByClause("create_time desc");//排序
		List<Comment> caseList4Page = commentMapper.selectByExample(ce);
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.comment, "留言评论列表信息");
		sysLogMapper.insert(sysLog);
		JsonPrintUtil.printGridData(response, caseList4Page, totalNums,"rows","total");
	}
	
	
	/**
	 * 实现留言评论模块的的评论功能
	 * @param commentId      所选的留言ID 值
	 * @return				 model 对象包含了返回值和返回的页面
	 */
	@RequestMapping("showComment")
	public ModelAndView showComment(int commentId,HttpSession session){
		
//		logger.info("成功加载showComment");
		ModelAndView model = new ModelAndView();
		Comment comment = commentMapper.selectByPrimaryKey(commentId);
		
		
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, comment.getCommentId(), TableName.comment, "留言信息");
		sysLogMapper.insert(sysLog);
		
		model.addObject("commentInfo", comment);
		model.setViewName("/admin/commentSave");
		return model;
	}
	
	/**
	 * 留言评论模块的评论回复
	 * @param comment   Comment实体类,封装了在线报属性修的全部信息
	 * @param response  用于动态响应客户端请示
	 * @param request   接受客户端所发出的请求
	 */
	@RequestMapping("saveComment")
	@ResponseBody
	public void saveComment(Comment comment,HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		
		int num = 0;
		if(null==comment.getCommentId()){
			comment.setCreateTime(new Date());
			num = commentMapper.insert(comment);
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.add(session, comment.getCommentId(), TableName.comment, "留言信息");
			sysLogMapper.insert(sysLog);
			
		}else{
			num = commentMapper.updateByPrimaryKeySelective(comment);//只更新传值的字段
			
			
//			日志记录
			SysLog sysLog = new SysLog();
			sysLog =SysLogUtil.edit(session, comment.getCommentId(), TableName.comment, "留言信息");
			sysLogMapper.insert(sysLog);
		}
		if(num>0){
			logger.info("savComment success!");
			JsonPrintUtil.printObjData(response, "ok");
		}
	}
	
	/**
	 * 留言评论模块的查询功能
	 * @param page        页码
	 * @param rows        行号
	 * @param keyWord     查询条件
	 * @param request     接受客户端所发出的请求
	 * @param response    用于动态响应客户端请示
	 */
	@RequestMapping("searchListComment")
	@ResponseBody
	// 页面参数：当前页 page 每页显示条数rows
	public void searchListComment(@RequestParam("page") int page,@RequestParam("rows") int rows,String keyWord,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		
		CommentExample ce = new CommentExample();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			//按访客的姓名和访客的电话进行查询，查询条件出删除之外的留言
			//1 表示未回复  2 表示已回复 3 表示已删除
			ce.or().andVisitorNameLike(keyWord).andStatusNotEqualTo(3);
			ce.or().andVisitorPhoneLike(keyWord).andStatusNotEqualTo(3);
			ce.or().andCommentDescLike(keyWord).andStatusNotEqualTo(3);
		}else{
			CommentExample.Criteria criteria = ce.createCriteria();
			//非删除状态
			criteria.andStatusNotEqualTo(3);
		}
		int totalNums = commentMapper.countByExample(ce);
		Page p = new Page((page - 1) * rows, rows);
		p.setTotalRecords(totalNums);
		ce.setPage(p);
		//排序
		ce.setOrderByClause("create_time desc");
		List<Comment> commentList4Page = commentMapper.selectByExample(ce);
		
			
//		日志记录
		SysLog sysLog = new SysLog();
		sysLog =SysLogUtil.search(session, 0, TableName.comment, "留言评论列表信息");
		sysLogMapper.insert(sysLog);
	
		JsonPrintUtil.printGridData(response, commentList4Page, totalNums,"rows","total");
	}
	
	
	
	/**
	 * 留言评论模块的删除功能
	 * @param commentIds  commentIds的数组,接收用于批量删除数据
	 * @param session     存储用户会话所需要的的属性和配置的全部信息
	 * @param request     接受客户端所发出的请求
	 */
	@RequestMapping("delComment")
	@ResponseBody
	public void delComment(String commentIds,HttpSession session,HttpServletResponse response) {
		if(!StringUtils.isBlank(commentIds)){
			String[] commentIdsArr = commentIds.split(",");
			for(int i=0;i<commentIdsArr.length;i++){
				int cId = Integer.parseInt(commentIdsArr[i]);
				Comment  comment= commentMapper.selectByPrimaryKey(cId);
				
				//1正常  3repair已删除 
				comment.setStatus(3);
				commentMapper.updateByPrimaryKeySelective(comment);
				
//				日志记录
				SysLog sysLog = new SysLog();
				sysLog =SysLogUtil.delete(session, comment.getCommentId(), TableName.comment, "留言评论信息");
				sysLogMapper.insert(sysLog);
				
			}
			JsonPrintUtil.printObjData(response, "ok");
		}else{
			JsonPrintUtil.printObjData(response, "fail");
		}
	}
	
	
	
}
