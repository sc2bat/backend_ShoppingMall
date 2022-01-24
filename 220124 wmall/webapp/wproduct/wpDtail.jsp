<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>

<article>
	<div id="pdetail" style="float:left;">
		<h1>Product Detail</h1>
		<form method="post" name="pdFrm">
			<fieldset>
				<input type="hidden" name="pd_pseq" value="${wpD.pseq }">
				<legend>Product Detail Info</legend>
				<span style="float:left; margin-right:20px;">
					<img src="wimages/${wpD.image }" style="border-radius:20px; width:200px;">
				</span>
				<h2>${wpD.name }</h2>
				<label>price : </label><p>${wpD.price_s }</p>
				<label>quantity : </label>
				<input type="text" name="quantity" size="2" value="1"> <br>
				<label>Content : </label><label>${wpD.content }</label> <br>
			</fieldset>
			<div class="clear"></div>
			<div id="buttons">
				<input type="button" value="Add to Cart" class="submit" onClick="add_cart();">
				<input type="button" value="Buy" class="submit" onClick="buy_now();">
				<input type="reset" value="Reset" class="cancel">	
			</div>
		</form>
	</div>
</article>

<%@ include file="../footer.jsp"%>
