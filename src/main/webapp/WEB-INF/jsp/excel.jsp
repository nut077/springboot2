<%@ page import="com.nutfreedom.excel.ExcelFreedom" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  ExcelFreedom excelFreedom = new ExcelFreedom(response, out, "excel", (String) request.getAttribute("excel"));
  excelFreedom.write();
%>