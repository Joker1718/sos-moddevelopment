/*     */ package tools.techgen;
/*     */ 
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ class GenPast
/*     */ {
/*     */   GenPast(boolean save) {
/*  11 */     BuilderTree tree = new BuilderTree("HUSB");
/*     */ 
/*     */ 
/*     */     
/*  15 */     tree.skip();
/*  16 */     Node n = new Node("HUNT00");
/*  17 */     n.name = "Hunting";
/*  18 */     n.desc = "Increases performance of the hunter";
/*  19 */     n.costInc = 4;
/*  20 */     n.costInc(COST.CIVIC_INNOVATION, 4);
/*  21 */     n.levels = 8;
/*  22 */     n.boost("ROOM_HUNTER_NORMAL>ADD", 0.5D);
/*  23 */     tree.add(n);
/*     */ 
/*     */     
/*  26 */     tree.newRight();
/*     */ 
/*     */     
/*  29 */     tree.newRight();
/*  30 */     tree.skip();
/*  31 */     BuilderNode b = new BuilderNode("ENTL", "Entelodont Pasture", "Entelodont Pastures", "Entelodont breeding");
/*  32 */     b.addKey("PASTURE_ENT", null);
/*  33 */     b.setToolLevel(4);
/*  34 */     b.setUpgrades(0);
/*  35 */     ArrayListGrower<Node> arrayListGrower7 = b.build(1.0D, new String[] { "32->BG->2", "32->animal->Entelodont->0" });
/*  36 */     tree.add((LIST<Node>)arrayListGrower7);
/*     */ 
/*     */     
/*  39 */     tree.newRight();
/*     */ 
/*     */     
/*  42 */     tree.newRight();
/*  43 */     tree.skip();
/*  44 */     b = new BuilderNode("ONX_", "Onx Pasture", "Onx Pastures", "Onx breeding");
/*  45 */     b.addKey("PASTURE_ONX", null);
/*  46 */     b.setToolLevel(4);
/*  47 */     b.setUpgrades(0);
/*  48 */     ArrayListGrower<Node> arrayListGrower6 = b.build(1.0D, new String[] { "32->BG->2", "32->animal->Onx->0" });
/*  49 */     tree.add((LIST<Node>)arrayListGrower6);
/*     */ 
/*     */     
/*  52 */     tree.newRight();
/*     */ 
/*     */     
/*  55 */     tree.newRight();
/*  56 */     tree.skip();
/*  57 */     b = new BuilderNode("AURU", "Auruch Pasture", "Auruch Pastures", "Auruch breeding");
/*  58 */     b.addKey("PASTURE_AUR", null);
/*  59 */     b.setToolLevel(4);
/*  60 */     b.setUpgrades(0);
/*  61 */     ArrayListGrower<Node> arrayListGrower5 = b.build(1.0D, new String[] { "32->BG->2", "32->animal->Auroch->0" });
/*  62 */     tree.add((LIST<Node>)arrayListGrower5);
/*     */ 
/*     */     
/*  65 */     tree.newRight();
/*     */ 
/*     */     
/*  68 */     tree.newRight();
/*  69 */     tree.skip();
/*  70 */     b = new BuilderNode("BALT", "Balitcrawler Pasture", "Balticrawler Pastures", "Balticrawler breeding");
/*  71 */     b.addKey("PASTURE_BALTI", null);
/*  72 */     b.setToolLevel(0);
/*  73 */     b.setUpgrades(0);
/*  74 */     ArrayListGrower<Node> arrayListGrower4 = b.build(0.5D, 0.75D, new String[] { "32->BG->6", "32->animal->Balticrawler->0" });
/*  75 */     for (int i = 0; i < arrayListGrower4.size(); i++) {
/*  76 */       ((Node)arrayListGrower4.get(i)).requireG("POPULATION_GARTHIMI_CITIZEN_I", 10 + 500 * i);
/*     */     }
/*  78 */     tree.add((LIST<Node>)arrayListGrower4);
/*     */ 
/*     */     
/*  81 */     tree.newRight();
/*     */ 
/*     */     
/*  84 */     tree.newRight();
/*  85 */     b = new BuilderNode("GLOB", "Globdien Pasture", "Globdien Pastures", "Globdien breeding");
/*  86 */     b.setUnlocks(8, "BUILDING_PASTURE_PASTURE_GLOBDIEN_1");
/*  87 */     b.addKey("PASTURE_GLOBDIEN", null);
/*  88 */     b.setToolLevel(4);
/*  89 */     b.setUpgrades(0);
/*  90 */     ArrayListGrower<Node> arrayListGrower3 = b.build(1.0D, new String[] { "32->BG->2", "32->animal->Globdien->0" });
/*  91 */     tree.add((LIST<Node>)arrayListGrower3);
/*     */ 
/*     */     
/*  94 */     tree.newRight();
/*     */ 
/*     */     
/*  97 */     tree.newRight();
/*  98 */     b = new BuilderNode("WARB", "Warbeast Pasture", "Warbeast Pastures", "Warbeast breeding");
/*  99 */     b.setUnlocks(30, "BUILDING_PASTURE_PASTURE_MOUNT_1");
/* 100 */     b.addKey("PASTURE_MOUNT", null);
/* 101 */     b.setToolLevel(4);
/* 102 */     b.setUpgrades(0);
/* 103 */     ArrayListGrower<Node> arrayListGrower2 = b.build(1.0D, new String[] { "32->BG->2", "32->animal->Mount->0" });
/* 104 */     tree.add((LIST<Node>)arrayListGrower2);
/*     */ 
/*     */     
/* 107 */     tree.newRight();
/*     */ 
/*     */     
/* 110 */     tree.newRight();
/* 111 */     b = new BuilderNode("FISH", "Fishery", "Fisheries", "Fishery breeding");
/* 112 */     b.addKey("FISHERY_NORMAL", null);
/* 113 */     b.setToolLevel(4);
/* 114 */     b.setUpgrades(1);
/* 115 */     ArrayListGrower<Node> arrayListGrower1 = b.build(1.0D, new String[] { "32->BG->5", "24->resource->Fish->0" });
/* 116 */     tree.add((LIST<Node>)arrayListGrower1);
/*     */ 
/*     */     
/* 119 */     tree.newRight();
/*     */ 
/*     */ 
/*     */     
/* 123 */     if (save) {
/* 124 */       tree.save(2, "32->_ICONS->10", "158_101_63", "Husbandry");
/*     */     }
/* 126 */     System.out.println(tree.build(0, "100_100_100", "32->_ICONS->10"));
/* 127 */     System.out.println(tree.buildText("Husbandry"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\GenPast.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */