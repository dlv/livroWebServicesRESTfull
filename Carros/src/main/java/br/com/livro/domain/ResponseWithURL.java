package br.com.livro.domain;

public class ResponseWithURL extends Response {

	private String url;

	public static ResponseWithURL Ok(String string, String url) {
		ResponseWithURL r = new ResponseWithURL();
		r.setStatus("OK");
		r.setMsg(string);
		r.setUrl(url);
		return r;
	}

	public static ResponseWithURL Error(String string) {
		ResponseWithURL r = new ResponseWithURL();
		r.setStatus("ERROR");
		r.setMsg(string);
		return r;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
