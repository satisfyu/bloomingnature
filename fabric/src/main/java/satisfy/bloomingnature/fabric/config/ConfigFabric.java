package satisfy.bloomingnature.fabric.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import satisfy.bloomingnature.BloomingNature;

@Config(name = BloomingNature.MOD_ID)
public class ConfigFabric implements ConfigData {
    //Misc
    @ConfigEntry.Category("misc")
    public boolean removeLavaLakes = true;
    @ConfigEntry.Category("misc")
    public boolean removeLavaLakesUnderground = true;

    //Plains
    @ConfigEntry.Category("plains")
    public int setPlainsGrassColor = 11063154;
    @ConfigEntry.Category("plains")
    public int setPlainsFoliageColor = 7386187;
    @ConfigEntry.Category("plains")
    public boolean removeVanillaPlainsFlowers = true;
    @ConfigEntry.Category("plains")
    public boolean removeVanillaPlainsTrees = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsTrees = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsFlowers = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsGrass = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsStoneBoulders = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsStoneMounds = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsSmallStoneMounds = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsGravelBeaches = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsStoneSlabs = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsBurriedTravertin = true;


    //River
    @ConfigEntry.Category("river")
    public int setRiverGrassColor = 11063154;
    @ConfigEntry.Category("river")
    public int setRiverFoliageColor = 10399058;
    @ConfigEntry.Category("river")
    public boolean removeVanillaRiverFlowers = true;
    @ConfigEntry.Category("river")
    public boolean removeVanillaRiverTrees = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverTrees = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverGrass = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverStoneBoulders = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverStoneMounds = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverSmallStoneMounds = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverGravelBeaches = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverStoneSlabs = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverBurriedTravertin = true;

    //ASPEN
    @ConfigEntry.Category("aspen")
    public int setOldGrowthBirchForestGrassColor = 14406505;
    @ConfigEntry.Category("aspen")
    public int setOldGrowthBirchForestFoliageColor = 10399058;
    @ConfigEntry.Category("aspen")
    public boolean removeVanillaOldGrowthBirchForestFlowers = true;
    @ConfigEntry.Category("aspen")
    public boolean removeVanillaOldGrowthBirchForestTrees = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestTrees = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestFallenTrees = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestFlowers = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestGrass = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchStoneSlabs = true;


    @ConfigEntry.Category("birch_forest")
    public boolean mofifyBirchForest = true;

}