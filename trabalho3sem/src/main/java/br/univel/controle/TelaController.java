package br.univel.controle;

public final class TelaController {
	
	private static TelaController self;
	
	private GlassPaneController controller;
	
	private TelaController() {
	}
	
	public synchronized static final TelaController getInstance() {
		if (self == null) {
			self = new TelaController();
		}
		return self;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public GlassPaneController getController() {
		return controller;
	}

	public void setController(GlassPaneController controller) {
		if (this.controller == null) {
			this.controller = controller;
		} else {
			throw new RuntimeException("setando duas vezes");
		}
	}
	
}
