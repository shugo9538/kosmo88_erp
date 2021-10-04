function dispatchInbound() {
	console.log(getContextPath() + "/wms/inbound/dispatchInbound");
	window.open(getContextPath() + "/wms/inbound/dispatchInbound", "haha", "width=800,height=600")

}

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};