/*     */ package tools.techgen;
/*     */ 
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ class GenMine
/*     */ {
/*     */   GenMine(boolean save) {
/*  11 */     BuilderTree tree = new BuilderTree("MINES");
/*     */ 
/*     */     
/*  14 */     tree.newRight();
/*  15 */     tree.skip();
/*  16 */     BuilderNode b = new BuilderNode("WOOD", "Woodcutter", "Woodcutters", "woodcutting");
/*  17 */     b.addKey("_WOODCUTTER", null);
/*  18 */     b.setToolLevel(4);
/*  19 */     b.setUpgrades(1);
/*  20 */     ArrayListGrower<Node> arrayListGrower7 = b.build(1.0D, new String[] { "32->WORK->0" });
/*  21 */     tree.add((LIST<Node>)arrayListGrower7);
/*     */ 
/*     */     
/*  24 */     tree.newRight();
/*     */ 
/*     */     
/*  27 */     tree.newRight();
/*  28 */     tree.skip();
/*  29 */     b = new BuilderNode("CLAY", "Clay Mine", "Clay Mines", "Extracting Clay");
/*  30 */     b.addKey("MINE_CLAY", null);
/*  31 */     b.setToolLevel(4);
/*  32 */     b.setUpgrades(2);
/*  33 */     ArrayListGrower<Node> arrayListGrower6 = b.build(1.0D, new String[] { "32->BG->4", "24->resource->Clay->0" });
/*  34 */     tree.add((LIST<Node>)arrayListGrower6);
/*     */ 
/*     */     
/*  37 */     tree.newRight();
/*     */ 
/*     */     
/*  40 */     tree.newRight();
/*  41 */     tree.skip();
/*  42 */     b = new BuilderNode("COAL", "Coal Mine", "Coal Mines", "Extracting Coal");
/*  43 */     b.addKey("MINE_COAL", null);
/*  44 */     b.setToolLevel(4);
/*  45 */     b.setUpgrades(2);
/*  46 */     ArrayListGrower<Node> arrayListGrower5 = b.build(1.0D, new String[] { "32->BG->4", "24->resource->Coal->0" });
/*  47 */     tree.add((LIST<Node>)arrayListGrower5);
/*     */ 
/*     */     
/*  50 */     tree.newRight();
/*     */ 
/*     */     
/*  53 */     tree.newRight();
/*  54 */     tree.skip();
/*  55 */     b = new BuilderNode("STON", "Stone Mine", "Stone Mines", "Extracting Stone");
/*  56 */     b.addKey("MINE_STONE", null);
/*  57 */     b.setToolLevel(4);
/*  58 */     b.setUpgrades(2);
/*  59 */     ArrayListGrower<Node> arrayListGrower4 = b.build(1.0D, new String[] { "32->BG->4", "24->resource->Stone->0" });
/*  60 */     tree.add((LIST<Node>)arrayListGrower4);
/*     */ 
/*     */     
/*  63 */     tree.newRight();
/*     */ 
/*     */     
/*  66 */     tree.newRight();
/*  67 */     tree.skip();
/*  68 */     b = new BuilderNode("ORE_", "Ore Mine", "Ore Mines", "Extracting Ore");
/*  69 */     b.addKey("MINE_ORE", null);
/*  70 */     b.setToolLevel(4);
/*  71 */     b.setUpgrades(2);
/*  72 */     ArrayListGrower<Node> arrayListGrower3 = b.build(1.0D, new String[] { "32->BG->4", "24->resource->Ore->0" });
/*  73 */     tree.add((LIST<Node>)arrayListGrower3);
/*     */ 
/*     */     
/*  76 */     tree.newRight();
/*     */ 
/*     */     
/*  79 */     tree.newRight();
/*  80 */     b = new BuilderNode("GEM_", "Gem Mine", "Gem Mines", "Extracting gems");
/*  81 */     b.setUnlocks(50, "BUILDING_MINE_MINE_GEM_1");
/*  82 */     b.addKey("MINE_GEM", null);
/*  83 */     b.setToolLevel(4);
/*  84 */     b.setUpgrades(2);
/*  85 */     ArrayListGrower<Node> arrayListGrower2 = b.build(1.0D, new String[] { "32->BG->4", "24->resource->Gem->0" });
/*  86 */     tree.add((LIST<Node>)arrayListGrower2);
/*     */ 
/*     */ 
/*     */     
/*  90 */     tree.newRight();
/*     */ 
/*     */     
/*  93 */     tree.newRight();
/*  94 */     b = new BuilderNode("SITH", "Sithilon Mine", "Sithilon Mines", "Extracting Sithilon");
/*  95 */     b.setUnlocks(60, "BUILDING_MINE_MINE_SITHILON_1");
/*  96 */     b.addKey("MINE_SITHILON", null);
/*  97 */     b.setToolLevel(4);
/*  98 */     b.setUpgrades(2);
/*  99 */     ArrayListGrower<Node> arrayListGrower1 = b.build(1.0D, new String[] { "32->BG->4", "24->resource->Sithilon->0" });
/* 100 */     tree.add((LIST<Node>)arrayListGrower1);
/*     */ 
/*     */ 
/*     */     
/* 104 */     if (save) {
/* 105 */       tree.save(3, "32->_ICONS->9", "255_216_0", "Extraction");
/*     */     }
/* 107 */     System.out.println(tree.build(0, "100_100_100", "32->_ICON->9"));
/* 108 */     System.out.println(tree.buildText("extraction"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\GenMine.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */