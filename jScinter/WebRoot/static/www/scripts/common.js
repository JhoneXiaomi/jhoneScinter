/*
* common plugins 
* create by guilin.li
*/
(function($){
	/*nav toggle，一二级导航*/
	$.fn.navs = function(options1,options2){ 
		var defaults1 = {ctag: 'li',curCss: 'current',overCss:'hover',click:null},
			defaults2 = {subnav: '#subnav',ptag:'ul',ctag:'li',curCss:'current',overCss:'hover',click:null},
			opts1 = $.extend(defaults1, options1),
			opts2 = $.extend(defaults2, options2);
		
		return this.each(function() {
			var o = $.meta ? $.extend(opts1, $this.data()) : opts1;
			var oo = $.meta ? $.extend(opts2, $this.data()) : opts2;
			var $this = $(this),
				nodes = $this.find(o.ctag),
				subnav = $(oo.subnav),
				subNavs = subnav.find(oo.ptag);
			//一级
			nodes.each(function(i,e){
				$(e).hover(function(){
					$(this).toggleClass(o.overCss);
				}).bind("click",{index:i},function(event){
					nodes.removeClass(o.curCss);
					$(this).addClass(o.curCss);
					var subCNodes = subNavs.hide().eq(i).find(oo.ctag);
					if(subCNodes.size()>0){
						subNavs.eq(i).show();
						subCNodes.removeClass(oo.curCss).eq(0).addClass(oo.curCss);
					}else{
						subNavs.eq(i).hide();
					}
					if(subNavs.eq(0).find(oo.ctag).size()>0) subNavs.eq(0).show();
					if(o.click) o.click(event.data.index);
				});
			});
			//二级
			subNavs.each(function(){
				var subCNodes = $(this).find(oo.ctag);
				subCNodes.each(function(i,e){
				    $(e).hover(function() {
                        $(this).toggleClass(o.overCss);
                    }).bind('click', {index:i},function(event) {
                        subCNodes.removeClass(oo.curCss);
                        $(this).addClass(oo.curCss);
                        if(oo.click) oo.click(event.data.index);
                    });
				});
			});			
		});
	};
	/*menu slider，菜单目前只支持到二级*/
    $.fn.menus = function(options){
        var defaults = {headTag:'.menuhead',conTag:'.menucon',height:0,curCss:'current',overCss:'hover',openFirst:true,click:null};
            opts = $.extend(true, defaults, options);
        return this.each(function(){
            var $this = $(this),
                o = $.meta ? $.extend(opts, $this.data()) : opts;
            $this.children(o.headTag).each(function(){
                $(this).unbind("click").bind("click",function(){
                    if($(this).hasClass(o.curCss)) return;
                    sildeLi($(this),$(this).next(o.conTag),o);
                    if(o.click) o.click($(this));
                }).unbind("hover").bind("hover",function(){
                    $(this).toggleClass(o.overCss);
                }); 
                if(o.height==0)
                    $(this).next(o.conTag).hide();
                else
                    $(this).next(o.conTag).height(0);
            });
            if(o.openFirst){
                var first = $this.children(o.headTag).first();
                sildeLi(first,first.next(o.conTag),o,true); 
            }
        });
        function sildeLi(head,con,o,notSlider){
            if(notSlider){
                if(con.height()>0){
                    con.height(0);
                }else{
                    con.height(o.height);
                }
                return; 
            }
            if(o.height==0){
                if(con.css("display")=="none"){
                    head.addClass(o.curCss);
                    con.slideDown("fast");
                }else{
                    head.removeClass(o.curCss);
                    con.slideUp("fast");
                }
            }else{
                if(con.height()>0){
                    con.animate({"height":0}, {complete:function(){head.removeClass(o.curCss);con.css("overflow","hidden");}});
                }else{
                    head.addClass(o.curCss);
                    con.animate({"height":o.height}, {complete:function(){con.css("overflow","auto");}});
                }
            }
        }
    };
    /*弹出框*/
    $.fn.winOpen=function(){
        var methods = {//扩展方法
            init: function(options) {
                return this.each(function() {
                    var $this = $(this);
                    var settings = $this.data('winOpen');
                    if(typeof(settings) == 'undefined') {
                        var defaults = {
                        		modal:true,
                        		name:"winopen",
                        		title:"",
                        		url:"",
                        		width:500,
                        		height:500,
                        		left:'50%',
                        		top:'50%',
                        		center:1,
                        		help:0,
                        		resizable:0,
                        		status:0,
                        		scroll:0,
                        		event:null,
                        		onClick:null,
                        		beforeOpen:null,
                        		afterOpen:null,
                        		Close:null,
                        		postData:{},
                        		returnData:{}
                        	};
                        settings = $.extend(true, defaults, options);
                        $this.data('winOpen', settings);
                    } else {
                        settings = $.extend(true, settings, options);
                        $this.data('winOpen', settings);
                    }
                    var o = settings;
                        o.width = o.width<1 ? o.width*$(window).width():o.width;
                        o.height = o.height<1 ? o.height*$(window).height():o.height;
                        if(o.center==1){
                        	o.top = (window.screen.availHeight-o.height)*0.5;
                        	o.left = (window.screen.availWidth-o.width)*0.5;
                        }
                    $this.delay = false;
                    if(o.event){
	                    $this.on(o.event,function(){
	                    	if(!$this.delay){
		                    	if(o.beforeOpen) if(!o.beforeOpen()) return;
		                    	try{
			                    	var wintop = window.top ||window;
			                    	var mask = wintop.$("#winmask");
			                        if(mask.size()==0)
			                        	wintop.$("body").append("<div class='winmask' id='winmask'></div>");
			                        else
			                        	mask.show()
		                        }catch(e){}
//		                        var cback = arguments.callee;
//		                        setTimeout(function(){
//		                        	$this.delay = true;
//		                        	cback();
//		                        },100);
//		                        return;
	                       }
	                    	var returnValue = window.showModalDialog(
	                    			o.url,
	                    			o.postData,
	                    			"dialogWidth="+o.width+"px"+
	                    			";dialogHeight="+o.height+"px"+
	                    			";dialogLeft="+o.left+
	                    			";dialogTop="+o.top+
	                    			";center="+o.center+
	                    			";help="+o.help+
	                    			";resizable="+o.resizable+
	                    			";status="+o.status+
	                    			";scroll="+o.scroll+ 
									";target='_self'" 
	                    			
	                    	);
	                        try{
	                        	var wintop = window.top ||window;
			                    wintop.$("#winmask").hide();
			                }catch(e){}
	                    	$this.data('returnValue', returnValue);
	                    	if(o.Close) o.Close($this);
	                    });
                    }else{
                    	if(!$this.delay){
	                    	if(o.beforeOpen) if(!o.beforeOpen()) return;
	                    	try{
		                    	var wintop = window.top ||window;
		                    	var mask = wintop.$("#winmask");
		                        if(mask.size()==0)
		                        	wintop.$("body").append("<div class='winmask' id='winmask'></div>");
		                        else
		                        	mask.show()
	                        }catch(e){}
//	                        var cback = arguments.callee;
//	                        setTimeout(function(){
//	                        	$this.delay = true;
//	                        	cback();
//	                        },100);
//	                        return;
	                    }
                    	var returnValue = window.showModalDialog(
	                    			o.url,
	                    			o.postData,
	                    			"dialogWidth="+o.width+"px"+
	                    			";dialogHeight="+o.height+"px"+
	                    			";dialogLeft="+o.left+
	                    			";dialogTop="+o.top+
	                    			";center="+o.center+
	                    			";help="+o.help+
	                    			";resizable="+o.resizable+
	                    			";status="+o.status+
	                    			";scroll="+o.scroll+ 
									";target='_self'" 
	                    			
	                    	);
                        try{
                        	var wintop = window.top ||window;
		                    wintop.$("#winmask").hide();
		                }catch(e){}
                    	$this.data('returnValue', returnValue);
                    	if(o.Close) o.Close();
                    }
                }); 
            },
            destroy: function(options) {
                return $(this).each(function() {
                    var $this = $(this);
                    $this.removeData('winOpen');
                });
            },
            val: function(options) {
                var someValue = this.eq(0).html();
                return someValue;
            }
        };
        //添加或修改url传参
        function _setParams(param,value,url){
            var reg = new RegExp('([\?&]?)' + param + '=[^&]*[&$]?', 'gi'),
                index = url.indexOf('?'),
                urlParam = "" ;
            if(index > -1){
                urlParam = url.slice(index),
                url = url.slice(0,index),
                urlParam = urlParam.replace(param,'$1');
            }
            
            if (urlParam == '') {
                urlParam += param + '=' + value;
            } else if (urlParam.substr(urlParam.length - 1,1) == '?' || urlParam.substr(urlArgs.length - 1,1) == '&') {
                urlParam += param + '=' + value;
            } else {
                urlParam += '&' + param + '=' + value;
            }
            if(!(/^\?.*?/gi).test(urlParam))
                urlParam = "?"+urlParam;
            return (url + urlParam);
        }
        //function _
        //添加方法
        var method = arguments[0];
        if(methods[method]) {
            method = methods[method];
            arguments = Array.prototype.slice.call(arguments, 1);
        } else if( typeof(method) == 'object' || !method ) {
            method = methods.init;
        } else {
            $.error( 'Method ' +  method + ' does not exist on jQuery.winOpen' );
            return this;
        }
        return method.apply(this, arguments);
    };
    /*
	*wresize
	*/
	$.fn.wresize = function(f){
		function handleWResize(e){
			if(f){
				if(f.tid)clearTimeout(f.tid);
				f.tid=setTimeout(function(){
					f.call([e]);
				},100)
			}
		}
		this.each(function(){
			if (this == window){
				$(this).resize(handleWResize);
			}else{
				$(this).resize(f);
			}
		});
		return this;
	};
	/*datagrid.methods*/
	if($.fn.datagrid){
    	$.extend($.fn.datagrid.methods, {
    		editCell: function(jq,param){
    			return jq.each(function(){
    				var opts = $(this).datagrid('options');
    				var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
    					var col = $(this).datagrid('getColumnOption', fields[i]);
						alert(col.editor);
    					col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
    				}
    				$(this).datagrid('beginEdit', param.index);
    				for(var i=0; i<fields.length; i++){
    					var col = $(this).datagrid('getColumnOption', fields[i]);
    					col.editor = col.editor1;
    				}
    				$(".datagrid-editable-input").focus();
    			});
    		},
			// 激活某字段表格列的编辑状态
			// create by guoshun.hou 20130926
			activateColumnEditor:function(jq,columnsNames){
				return jq.each(function(){
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (columnsNames.indexOf(fields[i])<0){
							col.editor = null;
						}
					}
					for(var i=0; i<$(this).datagrid('getRows').length; i++){
						$(this).datagrid('beginEdit', i);
					}
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			},
			// 合并指定列内容相同的单元格
			// create by guoshun.hou 20130922
			mergeCellsByField: function(jq, colList){
				return jq.each(function(){
					if(!colList)
						colList = $(this).data('colList');
					else
						$(this).data('colList',colList);
					var ColArray = colList.split(',');
					var TableRowCnts = $(this).datagrid('getRows').length;
					var tmpA;
					var tmpB;
					var PerTxt = '';
					var CurTxt = '';
					var alertStr = '';
					for(j=ColArray.length-1;j>=0;j--){
						PerTxt = "";
						tmpA = 1;
						tmpB = 0;
						for(i=0;i<=TableRowCnts;i++){
							if(i==TableRowCnts)
								CurTxt = '';
							else
								CurTxt = $(this).datagrid('getRows')[i][ColArray[j]];
							if(PerTxt==CurTxt)
								tmpA += 1;
							else{
								tmpB += tmpA;
								$(this).datagrid('mergeCells',{
									index: i-tmpA,
									field: ColArray[j],
									rowspan: tmpA,
									colspan: null
								});
								tmpA = 1;
							}
							PerTxt = CurTxt;
						}
					}
					$(this).data('Complex',1);
					$(this).datagrid("selectComplexRow");
				});
			},
			// 拆分合并的复杂单元格
			// create by guoshun.hou 20131121
			breakApartComplexRow: function(jq){
				return jq.each(function(){
					var table = $(this).datagrid('getPanel').find('.datagrid-body > table');
					table[0].className = table[0].className.replace(/[ ]?tr\d+_sel[ ]?/gi,'');
					$('td[rowspan]',table).removeAttr('rowspan');
					$('td',table).each(function(){
						$(this).unbind();
						this.className = this.className.replace('datagrid-td-merged','').replace(/[ ]?tr\d+(?![_\d])[ ]?/gi,'');
					});
					$('td[field="' + $(this).data('colList').replace(',','"]:hidden,td[field="') + '"]:hidden',table).show();
				});
			},
			// 删除含复杂单元格的指定行
			// create by guoshun.hou 20131121
			deleteComplexRow:function(jq,index){
				return jq.each(function(){
					$(this).datagrid('breakApartComplexRow');
					$(this).datagrid('deleteRow',index);
					$(this).datagrid('mergeCellsByField',$(this).data('colList'));
					if($(this).datagrid('options').striped){
						var rows = $(this).datagrid('getPanel').find('.datagrid-body > table > tbody > tr');
						rows.removeClass('datagrid-row-alt');
						rows.filter(':odd').addClass('datagrid-row-alt');
					}
				});
			},
			// 复杂表格选择和鼠标浮动整行背景色
			// create by guoshun.hou 20130930 optimize 20131022
			selectComplexRow:function(jq){
				return jq.each(function(){
					var _jq = $(this);
					var table = _jq.datagrid('getPanel').find('.datagrid-body > table');
					var tdoverStyle = $('#tdoverStyle');
					if(!tdoverStyle[0])$('<style id="tdoverStyle" />').appendTo(document.body);
					var tdSelectedStyle = $('<style id="' + $(this)[0].id + 'TdSelectedStyle" />').appendTo(document.body);
					table.each(function(){
					$(this).find('tr').each(function(i){
						$(this).find('td').each(function(){
							$(this).addClass('tr'+(i+1));
							this.rowspan = parseInt($(this).attr('rowspan'));
							if(this.rowspan > 1)for(var j=1; j<this.rowspan; j++){$(this).addClass('tr'+(i + 1 + j));}
							$(this).mouseover(function(){
								var cls = this.className.match(/tr\d+/gi);
								if(this.rowspan > 100){
									table[0].className += ' ' + cls.join(' ');
									var cssText = '';
									for(var i=0; i<cls.length; i++){cssText += '.' + cls[i] + ' .' + cls[i] + (i!=(cls.length-1)?',':'');}
									cssText += '{background:#FAF3E1;}';
									try{
										tdoverStyle.html(cssText);
									}catch(ex){
										tdoverStyle[0].styleSheet.cssText = tdoverStyle.html() + cssText;
									}
								}else{
									table.find('.'+cls.join(',.')).addClass('td_over');
								}
							}).mouseout(function(){
								if(this.rowspan > 100){
									table[0].className = table[0].className.replace(/tr\d+(?![_\d])/gi,'');
									try{
										tdoverStyle.html('');
									}catch(ex){
										tdoverStyle[0].styleSheet.cssText = '';
									}
								}else{
									table.find('.'+this.className.match(/tr\d+/gi).join(',.')).removeClass('td_over');
								}
							}).click(function(){
								var _this = this;
								var cls = _this.className.match(/tr\d+/gi);
								var isSeledted = table.is('.' + cls.join('_sel,.') + '_sel');
								if(_jq.datagrid('options').singleSelect){
									if(!isSeledted){
										table[0].className = table[0].className.replace(/tr\d+_sel[ ]?/gi,'');
										try{
											tdSelectedStyle.html('');
										}catch(ex){
											tdSelectedStyle[0].styleSheet.cssText = '';
										}
										table.addClass(cls[0] + '_sel');
									}else
										return;
								}else{
									if(isSeledted){
										table.removeClass(cls.join('_sel ') + '_sel');
										if(_this.rowspan > 1)
											setTimeout(function(){table.find('.'+_this.className.match(/tr\d+/gi).join(',.')).each(function(){$(this).parent().removeClass('datagrid-row-selected');});},10);
									}else{
										table.addClass(cls.join('_sel ') + '_sel');
										if(_this.rowspan > 1)
											setTimeout(function(){table.find('tr .'+_this.className.match(/tr\d+/gi).join(':not([rowspan]):first-child,tr .')+':not([rowspan]):first-child').each(function(){$(this).parent().addClass('datagrid-row-selected');});},10);
									}
								}
								var cssText = "";
								for(var i=0; i<cls.length; i++){cssText += '.' + cls[i] + '_sel .' + cls[i] + (i!=(cls.length-1)?',':'');}
								cssText += '{background:#FBEBBF;}';
								if(tdSelectedStyle.html().indexOf(cssText)>=0)return;
								try{
									tdSelectedStyle.html(tdSelectedStyle.html() + cssText);
								}catch(ex){
									tdSelectedStyle[0].styleSheet.cssText=tdSelectedStyle.html() + cssText;
								}
							});
						});
					});
				});
				});
			}
    	});
    	$.extend($.fn.datagrid.defaults.editors, {  
    	    select: {  
    	        init: function(container, options){
    	        	var data = options.data,len=data.length,html="",onchange = options.onChange;
    	        	while(len--){
    	        		html += "<option value="+data[len].value+">"+data[len].text+"</option>";
    	        	}
    	            var select = $('<select>'+html+'</select>').appendTo(container).on("change",function(){if(typeof onchange == "function") onchange(this);});
    	            return select;
    	        },
    	        getValue: function(target){  
    	            return $(target).val();
    	        },
    	        setValue: function(target, value){  
    	            $(target).val(value);
    	        },
    	        resize: function(target, width){  
    	            var select = $(target);  
    	            if ($.boxModel == true){  
    	            	select.width(width - (select.outerWidth() - select.width())-10);  
    	            } else {  
    	            	select.width(width-10);
    	            }  
    	        }  
    	    }  
    	});
   };
})(jQuery);

//格式化json模板
function formatJson(str,args){
	if(!str) return str='';
	for(var i in args){
		var reg= new RegExp('\{('+i+')\}',"g");
		str = str.replace(reg,args[i]);
	}
	return str;
}
//debugging    
function debug(info) {
	if (window.console && window.console.log)    
	window.console.log('out: ' + info);
};
//双击不选中
var clearSelection = function () {
    if(document.selection && document.selection.empty) {
        document.selection.empty();
    }
    else if(window.getSelection) {
        var sel = window.getSelection();
        sel.removeAllRanges();
	}
};

(function($){
    //按钮效果
    $("button.button").hover(function(){$(this).toggleClass("bhover")}).mousedown(function(){$(this).addClass("bclick");}).mouseup(function(){$(this).removeClass("bclick")});
    $("button.sbutton").hover(function(){$(this).toggleClass("shover")}).mousedown(function(){$(this).addClass("sclick");}).mouseup(function(){$(this).removeClass("sclick")});
    $("button.bbutton").hover(function(){$(this).toggleClass("bbhover")}).mousedown(function(){$(this).addClass("bbclick");}).mouseup(function(){$(this).removeClass("bbclick")});
	$("button.selbutton1").hover(function(){$(this).toggleClass("selhover1")}).mousedown(function(){$(this).addClass("selclick1");}).mouseup(function(){$(this).removeClass("selclick1")});
	$("button.selbutton2").hover(function(){$(this).toggleClass("selhover2")}).mousedown(function(){$(this).addClass("selclick2");}).mouseup(function(){$(this).removeClass("selclick2")});
	$("button.selbutton3").hover(function(){$(this).toggleClass("selhover3")}).mousedown(function(){$(this).addClass("selclick3");}).mouseup(function(){$(this).removeClass("selclick3")});
	$("button.selbutton4").hover(function(){$(this).toggleClass("selhover4")}).mousedown(function(){$(this).addClass("selclick4");}).mouseup(function(){$(this).removeClass("selclick4")});
	$(".sch input.txt").click(function(){var defaultVal=$(this).attr("value");if(this.value==defaultVal){$(this).val("").addClass("on");}}).blur(function(){var defaultVal=$(this).attr("value");if(this.value==""){$(this).val(defaultVal).removeClass("on");}});
	$(".extend-button").on("click",function(){$(this).toggleClass('extend-button-collapse');});
	$("div.uploadFile").hover(function(){$(this).toggleClass("hbtn_upload")}).mousedown(function(){$(this).addClass("cbtn_upload");}).mouseup(function(){$(this).removeClass("cbtn_upload")});
	$("button.close").click(function(){window.close();});
})(jQuery);


//日期比较、日期不能晚于今天
(function($){
	$.fn.tdDate = function(options){ 
		var defaults = {obj:'div.calendar-body',children: 'td',className:'calendar-other-month',click:null},
			opts = $.extend(defaults, options);
		return this.each(function() {
			var o = $.meta ? $.extend(opts1, $this.data()) : opts;
			var $this = $(this);
				$children = $this.find(o.children);
				$children.each(function(){
					var tdDate=$(this).attr("abbr");
					//alert("ddd");
					var tdArray=tdDate.split(',');
					tdArray[1]=formatorDate(tdArray[1]);
					tdArray[2]=formatorDate(tdArray[2]);
					tdDate=tdArray[0]+"-"+tdArray[1]+"-"+tdArray[2];
					var d1=curDate();
					var d2=tdDate;
					var bool=dateCompare2(d1,d2);
					if(bool)
					{
						$(this).addClass("calendar-other-month");
					}
				});
						
		});
	}
	})(jQuery);
 function curDate(){
	 	var today = new Date();
		var y = today.getFullYear();
		var m = today.getMonth()+1;
		var d = today.getDate();
		var tdDate=null;
		m=formatorDate(m);
		d=formatorDate(d);
		var d1=y+"-"+m+"-"+d;
		return d1;
	 
	 }
	function dateCompare(d2){
		var d1=curDate();
		dateCompare1(d1,d2);   
	}
	function dateCompare1(d1,d2){
		var reg=new RegExp("-","g"); //创建正则RegExp对象  
		var tempBeginTime=d1.replace(reg,"\/");      
		var tempEndTime=d2.replace(reg,"\/");       
		//比较时间大小，开始时间一定要小于结束时间       
		if(Date.parse(new Date(tempBeginTime))>Date.parse(new Date(tempEndTime))){
			alert("开始时间不能晚于结束时间");
			$('#js_planstart').datebox("setValue",d1);
			return;
		} 
	}
	function dateCompare2(d1,d2){
		var reg=new RegExp("-","g"); //创建正则RegExp对象  
		var tempBeginTime=d1.replace(reg,"\/");      
		var tempEndTime=d2.replace(reg,"\/");       
		//比较时间大小，开始时间一定要小于结束时间       
		if(Date.parse(new Date(tempBeginTime))>Date.parse(new Date(tempEndTime))){
			return true;
		} 
		else{
		 return false;
		}
	}
	 //格式化月和日
	 function formatorDate(time){
		if(time.toString().length == 1)
		{
			time="0"+time;
			return time;
		}
		else{
			return time;
			}
	 }

//textarea自动增高
function addEvent(){
	var obj_textarea = document.getElementsByTagName("textarea");
	if(obj_textarea[0]=="undefined"||obj_textarea[0]==null) return;
	for(var i=0;i<3;i++){
		if(obj_textarea[i])
		{
			if (window.addEventListener) {//Mozilla系列
				obj_textarea[i].addEventListener('input', TextAreaH_NOIE, false);
			} else if (window.attachEvent) {//IE
				//obj_textarea[i].attachEvent('onpropertychange',function (){TextAreaH_NOIE(obj_textarea[i]);} );
				obj_textarea[i].onpropertychange=function(){if(this.scrollHeight>0)this.style.height=this.scrollTop+this.scrollHeight+ 'px'} 			
			}
		}
	}
	
	function TextAreaH_NOIE(){
		this.style.height=this.scrollTop+this.scrollHeight + 'px';
	}
}
//create by guoshun.hou on 20130917
//目录树节点：上（-1）下（1）移
function move(sender, path, fn){
	var tr = $(sender).parents('.datagrid-row');
	var trSub = tr.next('tr.treegrid-tr-tree');
	if(path==1){
		var sib = tr.nextAll('tr:not(.treegrid-tr-tree):first');
		var sibSub = sib.next('tr.treegrid-tr-tree');
		if(sib[0]){
			if(sibSub[0]){
				tr.insertAfter(sibSub);
			}else{
				tr.insertAfter(sib);
			}
			trSub.insertAfter(tr);
			if(fn)fn.call(tr,sib);
		}else{
			alert('已到最下位置');	
		}
	}else{
		var sib = tr.prevAll('tr:not(.treegrid-tr-tree):first');
		var sibSub = sib.next('tr.treegrid-tr-tree');
		if(sib[0]){
			tr.insertBefore(sib);
			trSub.insertAfter(tr);
			if(fn)fn.call(tr,sib);
		}else{
			alert('已到最上位置');	
		}
	}
}
/*input file upload style*/
(function($) {  
    $.fn.filestyle = function(options) {          
        /* TODO: This should not override CSS. */
        var settings = {
            width : 250
        };                
        if(options) {
            $.extend(settings, options);
        };                    
        return this.each(function() {           
            var self = this;
            var wrapper = $("<div>")
                            .css({
                                "width": settings.imagewidth + "px",
                                "height": settings.imageheight + "px",
                                "background": "url(" + settings.image + ") 0px 0px no-repeat",
                                "background-position": settings.backgroundPosition,
                                "display": "inline",
								"position":"absolute",
                                "overflow": "hidden",
								"cursor": "pointer",
								"margin-left":"5px"
                            });
							
			var filename = $('<input class="txt">')
                             .addClass($(self).attr("class"))
                             .css({
                                 "display": "inline"
                             });
			$(self).before(filename);
            $(self).wrap(wrapper);

            $(self).css({
				"position": "relative",
				"height": settings.imageheight + "px",
				"width": settings.width + "px",
				"display": "inline",
				"cursor": "pointer",
				"opacity": "0.0"
			});

            $(self).on("change", function() {
				filename.val($(self).val());
            });
      
        });
    };
})(jQuery);

//about new\edit\details page align
function tableAlign(parent){
	if(navigator.userAgent.indexOf("MSIE 6.0")>0||navigator.userAgent.indexOf("MSIE 7.0")>0){
		var hScroll,hh,wScroll,ww;
		hScroll=document.getElementById(parent).scrollHeight;
		hh=document.getElementById(parent).clientHeight;
		wScroll=document.getElementById(parent).scrollWidth;
		ww=document.getElementById(parent).clientWidth;
		$("#"+parent).addClass("hidden-x").addClass("hidden-y");
		if((hScroll-hh<18)&&(wScroll-ww<18))
		{	//alert("both no");
			$("#"+parent).addClass("hidden-x").addClass("hidden-y");
		}
		else if((hScroll-hh<18)&&(wScroll-ww>=18)){//alert("x");
			$("#"+parent).addClass("hidden-y").removeClass("hidden-x");
		}
		else if((hScroll-hh>=18)&&(wScroll-ww<18)){//alert("y");
			$("#"+parent).addClass("hidden-x").removeClass("hidden-y");
		}
		else if((hScroll-hh>=18)&&(wScroll-ww>=18)){//alert("both");
			$("#"+parent).removeClass("hidden-x").removeClass("hidden-y");
		}
	}	
}

//select ie6 bug
function selectShow_ie6(){
	var isIE=!!window.ActiveXObject;
	var isIE6=isIE&&!window.XMLHttpRequest;
		if(isIE6){
			$("#selCate").combo({
				onShowPanel:function(){
					$("div.combo-p").each(function() {
						if($(this).is(":visible")){
							$(this).find("div.combo-panel").css({"z-index":9999});
							$(this).append('<iframe name="selectIframe" id="selectIframe" src="" height="300px" width="247px" frameborder="0" scrolling="no" class="selectIframe" style="position:absolute;top:0;left:0;z-index:9998;background:#fff;"></iframe>');
						}
					});
				},
				onHidePanel:function(){
					$("div.combo-p").each(function(){
						if($(this).is(":hidden")){
							$(this).find("iframe").remove();
						}
					})
				}
			});
		}
}

if(!Array.prototype.indexOf){  
	    Array.prototype.indexOf = function(target){  
	        for(var i=0,l=this.length;i<l;i++){  
	            if(this[i] === target) return i;  
	        }  
	        return -1;  
	    };  
}  

//系统时间显示
function showLocale(objD) {
	var str, colorhead, colorfoot;
	var yy = objD.getYear();
	if (yy < 1900)
		yy = yy + 1900;
	var MM = objD.getMonth() + 1;
	if (MM < 10)
		MM = '0' + MM;
	var dd = objD.getDate();
	if (dd < 10)
		dd = '0' + dd;
	var hh = objD.getHours();
	if (hh < 10)
		hh = '0' + hh;
	var mm = objD.getMinutes();
	if (mm < 10)
		mm = '0' + mm;
	var ss = objD.getSeconds();
	if (ss < 10)
		ss = '0' + ss;
	var ww = objD.getDay();
	if (ww == 0)
		colorhead = "<font color=\"#008000\">";
	if (ww > 0 && ww < 6)
		colorhead = "<font color=\"#373737\">";
	if (ww == 6)
		colorhead = "<font color=\"#008000\">";
	if (ww == 0)
		//ww = "Sunday";
		ww = "星期日";
	if (ww == 1)
		//ww = "Monday";
		ww = "星期一";
	if (ww == 2)
		//ww = "Tuesday";
		ww = "星期二";
	if (ww == 3)
		//ww = "Wendesday";
		ww = "星期三";
	if (ww == 4)
		//ww = "Thursday";
		ww = "星期四";
	if (ww == 5)
		//ww = "Friday";
		ww = "星期五";
	if (ww == 6)
		//ww = "Saturday";
		ww = "星期六";
	colorfoot = "</font>";
	str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":"
			+ ss + " " + ww + colorfoot;
	return (str);
}
function tick() {
	var today;
	today = new Date();
	document.getElementById("dateTime").innerHTML = showLocale(today);
	window.setTimeout("tick()", 1000);
}

//格式化分公司信息列表展现
function formatCompanyName(value){
	if(value=="bjsc"){
		return "北京三创";
	}
	if(value=="hssc"){
		return "衡水三创";
	}
	if(value=="sjzsc"){
		return "石家庄三创";
	}
	if(value=="tjsc"){
		return "天津三创";
	}
	if(value=="hdsc"){
		return "邯郸三创";
	}
	if(value=="lfsc"){
		return "廊坊三创";
	}
	if(value=="yjsc"){
		return "燕郊三创";
	}
	if(value=="bdsc"){
		return "保定三创";
	}
	if(value=="tssc"){
		return "唐山三创";
	}
	if(value=="bjxz"){
		return "北京新洲";
	}
	if(value=="tjxz"){
		return "天津新洲";
	}
	if(value=="tsxz"){
		return "唐山新洲";
	}
	if(value=="bdxz"){
		return "保定新洲";
	}
	if(value=="tyxz"){
		return "太原新洲";
	}
	if(value=="lfxz"){
		return "廊坊新洲";
	}
	if(value=="sjzxz"){
		return "石家庄新洲";
	}
	if(value=="czxz"){
		return "沧州新洲";
	}
	if(value=="zzxz"){
		return "郑州新洲";
	}
	if(value=="jnxz"){
		return "济南新洲";
	}
	if(value=="hfxz"){
		return "合肥新洲";
	}
	if(value=="cqxz"){
		return "重庆新洲";
	}
	if(value=="sjzrbw1"){
		return "石家庄瑞博文(1)";
	}
	if(value=="bdrbw1"){
		return "保定瑞博文(1)";
	}
	if(value=="hsrbw1"){
		return "衡水瑞博文(1)";
	}
	if(value=="lfrbw1"){
		return "廊坊瑞博文(1)";
	}
	if(value=="hsrbw2"){
		return "衡水瑞博文(2)";
	}
	if(value=="sjzrrl"){
		return "石家庄人人乐";
	}
}
