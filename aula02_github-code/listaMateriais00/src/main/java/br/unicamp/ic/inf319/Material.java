package br.unicamp.ic.inf319;

import java.util.UUID;

public class Material {

	private Double price;
	private String description;
	private UUID uuid;
	private MaterialList billOfMaterials;

	public Material(UUID serialUID) {
		super();
		price = 0.0D;
		description = "";
		this.uuid = serialUID;
		billOfMaterials = new MaterialList();
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getUUID() {
		return uuid;
	}

	public MaterialList getBillOfMaterials() {
		return billOfMaterials;
	}

	public void setBillOfMaterials(MaterialList billOfMaterials) {
		this.billOfMaterials = billOfMaterials;
	}

	public boolean isAtomic() {
		return billOfMaterials.getRequiredMaterials().isEmpty();
	}

	public Double getTotalAmount() {
		double cost;
		if (isAtomic()) {
			cost = price;
		} else {
			cost = billOfMaterials.getRequiredMaterials().stream().mapToDouble(t -> t.getTotalAmount()).sum();
		}
		return cost;
	}
}
