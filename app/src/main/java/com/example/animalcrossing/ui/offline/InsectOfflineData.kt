package com.example.animalcrossing.ui.offline

import com.example.animalcrossing.ui.insect.model.InsectModel

class InsectOfflineData {

    private val map : HashMap<String, Boolean> = HashMap()

    private val insectData1 = InsectModel(1,"Common Butterfly", false, listOf("Jan", "Feb", "Mar", "Oct", "Nov", "Dec"), "0006", 8000, 0.99f)
    private val insectData2 = InsectModel(2,"Yellow Butterfly", true, listOf("Jan", "Feb", "Mar", "Oct", "Nov", "Dec"), "0006", 350, 0.99f)
    private val insectData3 = InsectModel(3,"Tiger Butterfly", false, listOf("Jan", "Feb", "Mar", "Oct", "Nov", "Dec"), "0006", 350, 0.99f)
    private val insectData4 = InsectModel(4,"Peacock Butterfly", false, listOf("Jan", "Feb", "Mar", "Oct", "Nov", "Dec"), "0006", 350, 0.99f)
    private val insectData5 = InsectModel(5,"Paper Kite Butterfly", false, listOf("Jan", "Feb", "Mar", "Oct", "Nov", "Dec"), "0006", 350, 0.99f)
    private val insectData6 = InsectModel(6,"Common Bluebottle", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData7 = InsectModel(7,"Great Purple Emperor", false, listOf("Jan"), "0006", 350, 0.99f)
    private val insectData8 = InsectModel(8,"Monach Butterfly", false, listOf("Jan"), "0006", 350, 0.99f)
    private val insectData9 = InsectModel(9,"Emperor Butterfly", true, listOf("Jan"), "0006", 350, 0.99f)
    private val insectData10 = InsectModel(10,"Agrias Butterfly", false, listOf("Jan"), "0006", 350, 0.99f)
    private val insectData11 = InsectModel(11,"Raja Brooke's Birdwing", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData12 = InsectModel(12,"Queen Alexandra's Birdwing", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData13 = InsectModel(13,"Moth", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData14 = InsectModel(14,"Atlas Moth", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData15 = InsectModel(15,"Madagascan Sunset Moth", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData16 = InsectModel(16,"Long Locust", true, listOf("Jan"), "0006", 350, 0.99f)
    private val insectData17 = InsectModel(17,"Migratory Locust", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData18 = InsectModel(18,"Rice Grasshopper", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData19 = InsectModel(19,"Grasshopper", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData20 = InsectModel(20,"Cricket", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData21 = InsectModel(21,"Bell Cricket", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData22 = InsectModel(22,"Mantis", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData23 = InsectModel(23,"Orchid Mantis", true, listOf("Jan"), "0006", 350, 0.99f)
    private val insectData24 = InsectModel(24,"Honeybee", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData25 = InsectModel(25,"Wasp", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData26 = InsectModel(26,"Brown Cicada", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData27 = InsectModel(27,"Robust Cicada", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData28 = InsectModel(28,"Giant Cicada", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData29 = InsectModel(29,"Walker Cicada", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData30 = InsectModel(30,"Evening Cicada", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData31 = InsectModel(31,"Cicada Shell", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData32 = InsectModel(32,"Red Dragonfly", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData33 = InsectModel(33,"Darner Dragonfly", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData34 = InsectModel(34,"Banded Dragonfly", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData35 = InsectModel(35,"Damselfly", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData36 = InsectModel(36,"Firefly", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData37 = InsectModel(37,"Mole Cricket", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData38 = InsectModel(38,"Pondskater", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData39 = InsectModel(39,"Diving Beetle", false, listOf("Jul"), "0006", 350, 0.99f)
    private val insectData40 = InsectModel(40,"Giant Water Bug", false, listOf("Jul"), "0006", 350, 0.99f)

    private val insectList = listOf(insectData1,insectData2,insectData3,insectData4,insectData5,insectData6,insectData7,insectData8,insectData9,insectData10,insectData11,insectData12,insectData13,insectData14,insectData15,insectData16,insectData17,insectData18,insectData19,insectData20,insectData21,insectData22,insectData23,insectData24,insectData25,insectData26,insectData27,insectData28,insectData29,insectData30,insectData31,insectData32,insectData33,insectData34,insectData35,insectData36,insectData37,insectData38,insectData39,insectData40)

    fun getInsectOfflineData(): List<InsectModel> {
        return insectList
    }



}