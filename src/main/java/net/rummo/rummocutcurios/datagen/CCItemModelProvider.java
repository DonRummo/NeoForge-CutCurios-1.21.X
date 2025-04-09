package net.rummo.rummocutcurios.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.item.CCItems;

public class CCItemModelProvider extends ItemModelProvider
{

    public CCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, RummoCutCurios.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        basicItem(CCItems.RAW_RUBY.get());
    }
}
