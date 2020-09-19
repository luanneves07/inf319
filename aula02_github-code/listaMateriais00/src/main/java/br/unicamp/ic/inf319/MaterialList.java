package br.unicamp.ic.inf319;

import java.util.ArrayList;
import java.util.List;

public class MaterialList {

	private List<Material> requiredMaterials;

	public MaterialList() {
		this(new ArrayList<Material>());
	}

	public MaterialList(List<Material> requiredMaterials) {
		super();
		this.requiredMaterials = requiredMaterials;
	}

	public List<Material> getRequiredMaterials() {
		return requiredMaterials;
	}

	public void add(Material required) {
		requiredMaterials.add(required);
	}

	public double getTotalAmount() {
		return requiredMaterials.stream().mapToDouble(t -> t.getTotalAmount()).sum();
	}
}
