package com.boredom;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import com.boredom.datagen.*;

public class BoredAtSchoolDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		//pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ItemTagProvider::new);
		//pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModelProvider::new);
		//pack.addProvider(ModRecipeProvider::new);
		//pack.addProvider(ModPoiTagProvider::new);
	}
}