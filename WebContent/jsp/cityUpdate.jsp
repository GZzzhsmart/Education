<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.CityVo"%>
<%@page import="bean.ProvinceVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改城市资料</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.cityName.value==""){
    			alert("请输入城市名称");
    			form1.cityName.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
      <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改城市资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>cityServlet?action=updateSave" method="post" >
     <%
    		CityVo city = (CityVo)request.getAttribute("city");
    	%>
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">省份名称：</label>
        </div>
        <div class="field">
          <select name="provinceId" style="width:155px">
				<%
					//获取request变量provList;
					List<ProvinceVo> provList = (List<ProvinceVo>)request.getAttribute("provList");
					if(provList!=null){
						for(int i=0;i<provList.size();i++){
							ProvinceVo p=provList.get(i);
							if(p.getProvinceId()==city.getProvinceId()){
								%>
								<!-- 如果要修改城市则选中省份名称 -->
								<option value="<%=p.getProvinceId() %>" selected="selected"><%=p.getProvinceName() %></option>
								<%
							}else{
							%>
								<!-- 如果不修改城市则不选中省份名称 -->
								<option value="<%=p.getProvinceId() %>"><%=p.getProvinceName() %></option>
							<%
							}
						}
					}
				 %>
				</select>      
        </div>
      </div>      
       <div class="form-group">
        <div class="label">
          <label for="sitename">城市名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="cityName" size="50" value="<%=city.getCityName() %>"  />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
