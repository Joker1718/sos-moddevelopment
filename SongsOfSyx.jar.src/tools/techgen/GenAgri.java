/*     */ package tools.techgen;
/*     */ 
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ class GenAgri
/*     */ {
/*     */   GenAgri(boolean save) {
/*  11 */     BuilderTree tree = new BuilderTree("AGRI");
/*     */     
/*  13 */     String ibg = "32->BG->3";
/*     */ 
/*     */     
/*  16 */     tree.skip();
/*  17 */     BuilderNode b = new BuilderNode("GRAI", "Grain Farm", "Grain Farms", "Grain farming");
/*  18 */     b.addKey("FARM_GRAIN", null);
/*  19 */     b.setToolLevel(4);
/*  20 */     b.setUpgrades(0);
/*  21 */     ArrayListGrower<Node> arrayListGrower8 = b.build(1.0D, new String[] { ibg, "24->resource->Grain->0" });
/*  22 */     tree.add((LIST<Node>)arrayListGrower8);
/*     */ 
/*     */     
/*  25 */     tree.newRight();
/*     */ 
/*     */     
/*  28 */     tree.newRight();
/*  29 */     tree.skip();
/*  30 */     b = new BuilderNode("FRUI", "Fruit Farm", "Fruit Farms", "fruit farming");
/*  31 */     b.addKey("FARM_FRUIT", null);
/*  32 */     b.setToolLevel(4);
/*  33 */     b.setUpgrades(0);
/*  34 */     ArrayListGrower<Node> arrayListGrower7 = b.build(1.0D, new String[] { ibg, "24->resource->Fruit->0" });
/*  35 */     tree.add((LIST<Node>)arrayListGrower7);
/*     */ 
/*     */     
/*  38 */     tree.newRight();
/*     */ 
/*     */     
/*  41 */     tree.newRight();
/*  42 */     tree.skip();
/*  43 */     b = new BuilderNode("VEGE", "Vegetable Farm", "Vegetable Farms", "Vegetable farming");
/*  44 */     b.addKey("FARM_VEG", null);
/*  45 */     b.setToolLevel(4);
/*  46 */     b.setUpgrades(0);
/*  47 */     ArrayListGrower<Node> arrayListGrower6 = b.build(1.0D, new String[] { ibg, "24->resource->Vegetable->0" });
/*  48 */     tree.add((LIST<Node>)arrayListGrower6);
/*     */ 
/*     */     
/*  51 */     tree.newRight();
/*     */ 
/*     */     
/*  54 */     tree.newRight();
/*  55 */     tree.skip();
/*  56 */     b = new BuilderNode("COTT", "Cotton Farm", "Cotton Farms", "Cotton farming");
/*  57 */     b.addKey("FARM_COTTON", null);
/*  58 */     b.setToolLevel(4);
/*  59 */     b.setUpgrades(0);
/*  60 */     ArrayListGrower<Node> arrayListGrower5 = b.build(1.0D, new String[] { ibg, "24->resource->Cotton->0" });
/*  61 */     tree.add((LIST<Node>)arrayListGrower5);
/*     */ 
/*     */     
/*  64 */     tree.newRight();
/*     */ 
/*     */     
/*  67 */     tree.newRight();
/*  68 */     b = new BuilderNode("MUSH", "Mushroom Farm", "Mushroom Farms", "Mushroom farming");
/*  69 */     b.setUnlocks(10, "BUILDING_AGRICULTURE_FARM_MUSHROOM_1");
/*  70 */     b.addKey("FARM_MUSHROOM", null);
/*  71 */     b.setToolLevel(4);
/*  72 */     b.setUpgrades(0);
/*  73 */     ArrayListGrower<Node> arrayListGrower4 = b.build(1.0D, new String[] { ibg, "24->resource->Mushroom->0" });
/*  74 */     tree.add((LIST<Node>)arrayListGrower4);
/*     */ 
/*     */     
/*  77 */     tree.newRight();
/*     */ 
/*     */     
/*  80 */     tree.newRight();
/*  81 */     b = new BuilderNode("HERB", "Herb Farm", "Herb Farms", "Herb farming");
/*  82 */     b.setUnlocks(20, "BUILDING_AGRICULTURE_FARM_HERB_1");
/*  83 */     b.addKey("FARM_HERB", null);
/*  84 */     b.setToolLevel(4);
/*  85 */     b.setUpgrades(0);
/*  86 */     ArrayListGrower<Node> arrayListGrower3 = b.build(1.0D, new String[] { ibg, "24->resource->Herb->0" });
/*  87 */     tree.add((LIST<Node>)arrayListGrower3);
/*     */ 
/*     */     
/*  90 */     tree.newRight();
/*     */ 
/*     */     
/*  93 */     tree.newRight();
/*  94 */     b = new BuilderNode("SPIC", "Poppy Farm", "Poppy Farms", "Poppy farming");
/*  95 */     b.setUnlocks(30, "BUILDING_AGRICULTURE_FARM_SPICES_1");
/*  96 */     b.addKey("FARM_SPICES", null);
/*  97 */     b.setToolLevel(4);
/*  98 */     b.setUpgrades(0);
/*  99 */     ArrayListGrower<Node> arrayListGrower2 = b.build(1.0D, new String[] { ibg, "24->resource->Opiates->0" });
/* 100 */     tree.add((LIST<Node>)arrayListGrower2);
/*     */ 
/*     */     
/* 103 */     tree.newRight();
/* 104 */     ibg = "32->BG->7";
/*     */     
/* 106 */     tree.newRight();
/* 107 */     tree.skip();
/* 108 */     b = new BuilderNode("OFRU", "Fruit Orchard", "Fruit Orchards", "Orcharding");
/* 109 */     b.addKey("ORCHARD_FRUIT", null);
/* 110 */     b.setToolLevel(4);
/* 111 */     b.setUpgrades(0);
/* 112 */     ArrayListGrower<Node> arrayListGrower1 = b.build(1.0D, new String[] { ibg, "24->resource->Fruit->0" });
/* 113 */     tree.add((LIST<Node>)arrayListGrower1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     if (save) {
/* 119 */       tree.save(1, "32->_ICONS->11", "158_101_63", "Agriculture");
/*     */     }
/* 121 */     System.out.println(tree.build(0, "100_100_100", "32->_ICONS->11"));
/* 122 */     System.out.println(tree.buildText("extraction"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\GenAgri.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */