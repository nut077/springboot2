<%@ page import="com.nutfreedom.pdf.PdfFreedom" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  PdfFreedom pdfFreedom = new PdfFreedom(application, response, out, "eiei", (String) request.getAttribute("pdf"));
  pdfFreedom.write();
%>