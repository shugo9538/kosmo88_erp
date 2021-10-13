<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kosmo88.logistics_erp.wms.dto.V_sectionDto"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Enumeration"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/wms/common/css_core.jspf"%>
<%@ include file="/WEB-INF/views/wms/common/settings.jspf"%>
</head>
<!-- <body class="sticky-header"> -->
<body class="warehousing">
	<div class="main-content">
		<div class="wrapper">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="white-box">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>입고 처리
							</h2>

							<form class="form-horizontal" method="post"
								action="${ROOT_PATH}/wms/inbound/warehousingAction"
								onsubmit="return warehousingAction()">
								<sec:csrfInput />
								<table id="clientList" class="display table" style="width: 100%">
									<thead>
										<tr>
											<th>품목</th>
											<th>수량</th>
											<th>입고 가능 섹션</th>
										</tr>
									</thead>
									<tbody>
										<%
										V_sectionDto sectionDto = null;
											System.out.println("테스트 : request내의 객체");
											Enumeration attr = request.getAttributeNames();
											int i = 0;
											while (attr.hasMoreElements()) {
												System.out.println(i + " : " + attr.nextElement());
												i++;
											}
											;
										%>
										<%--
                      <c:set var="sectionDtoList" value="${sectionDtoList}" />
                      --%>
										<c:forEach var="itemDto" items="${itemDtoList}">
											<input name="itemId" type="hidden" value="${itemDto.item_id}" />
											<input name="itemName" type="hidden"
												value="${itemDto.item_name}" />
											<input name="quantity" type="hidden"
												value="${itemDto.quantity}" />
												<input name="requestId" type="hidden"
												value="${itemDto.request_id}" />
											<tr>
												<%--
                          <td>${productDto.purchase_id}</td>
                          --%>
												<td class="item">${itemDto.item_name}</td>
												<td class="quantity">${itemDto.quantity}</td>
												<td><select id="section" name="section">
														<!-- 											onfocus='this.initialSelect = this.selectedIndex;' onchange="this.selectedIndex = this.initialSelect;" -->
														<option value="none">=== 선택 ===</option>
														<c:set var="sectionDtoList" value="${sectionDtoList}"></c:set>
																<%
																List<V_sectionDto> list = (List<V_sectionDto>) pageContext.getAttribute("sectionDtoList");
																System.out.println("size: " + list.size());
														%>

														<c:forEach var="sectionDto" items="${sectionDtoList}"
															varStatus="status">
															<c:out value="${itemDto.item_name}"></c:out>
															<c:out value="${sectionDto.item_name}"></c:out>
															<c:choose>
																<c:when
																	test="${itemDto.item_name eq sectionDto.item_name}">
																	<option class="section selected" value="${sectionDto.id}"
																		selected>${sectionDto.section}
																		(${sectionDto.item_name})
																		(${sectionDto.capacity-sectionDto.sum_count})</option>

														<%
															sectionDto = (V_sectionDto) pageContext.getAttribute("sectionDto");
																System.out.println(sectionDto);
																%>


																</c:when>
																<c:otherwise>
																	<option class="section" value="${sectionDto.id}">
																		${sectionDto.section} (${sectionDto.capacity })
																		<%--
                                      (${sectionDto.item_name}) --%>
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
														<%
															Iterator<V_sectionDto> listItr = list.iterator();
																while (listItr.hasNext()) {
																	V_sectionDto dto = listItr.next();
																	System.out.println(dto.toString());
																if (dto == sectionDto) {
																		System.out.println("삭제합니다 " + dto);
																		listItr.remove();
																		request.removeAttribute("sectionDtoList");
																		request.setAttribute("sectionDtoList", list);
																	}
																}
														%>
												</select></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="col-xs-2">
									<button type="submit" class="btn btn-default mt-5">입고
										처리</button>
								</div>
							</form>
							<!-- 							<div class="col-md-2 mt-1 mb-4"> -->
							<!-- 								<input class="btn btn-default" type="button" -->
							<!-- 									id="clientChoiceDeleteBtn" value="test" onclick=reloadOpener()> -->
							<!-- 							</div> -->
							<!-- 							<div class="centerBtnContainer"> -->
							<!-- 								<input type="button" class="btn-default align-self-center" -->
							<!-- 									onclick="warehousingAction()" -->
							<!-- 									value="입고 처리"> -->
							<!-- 							</div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/inbound.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/warehouse.js"></script>
</body>
</html>
