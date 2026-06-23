/*     */ package tools.techgen;
/*     */ 
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GenRefine
/*     */ {
/*     */   GenRefine(boolean save) {
/*  19 */     BuilderTree tree = new BuilderTree("REFINER");
/*     */ 
/*     */     
/*  22 */     BuilderNode b = new BuilderNode("BAKE", "Bakery", "Bakeries", "Baking");
/*  23 */     b.addKey("REFINER_BAKERY", null);
/*  24 */     b.setToolLevel(0);
/*  25 */     b.setUpgrades(2);
/*  26 */     ArrayListGrower<Node> arrayListGrower5 = b.build(1.0D, new String[] { "32->REFINER->0" });
/*  27 */     tree.add((LIST<Node>)arrayListGrower5);
/*     */ 
/*     */     
/*  30 */     Node prev = null;
/*  31 */     tree.newRight();
/*  32 */     tree.add(b.consumption(0.5D, 0, (Node)arrayListGrower5.last(), prev, "Wood oven Excellence", "Decreases consumption when making bread with wood as fuel."));
/*  33 */     tree.add(b.consumption(0.29D, 1, (Node)arrayListGrower5.last(), "Coal oven Excellence", "Decreases consumption when making bread with coal as fuel."));
/*     */     
/*  35 */     tree.newRight();
/*     */ 
/*     */ 
/*     */     
/*  39 */     tree.newRight();
/*     */ 
/*     */     
/*  42 */     b = new BuilderNode("BREW", "Brewery", "Breweries", "Brewing Drink");
/*  43 */     b.addKey("REFINER_BREWERY", null);
/*  44 */     b.setToolLevel(0);
/*  45 */     b.setUpgrades(2);
/*  46 */     ArrayListGrower<Node> arrayListGrower4 = b.build(2.0D, new String[] { "32->REFINER->1" });
/*  47 */     tree.add((LIST<Node>)arrayListGrower4);
/*     */ 
/*     */     
/*  50 */     prev = null;
/*  51 */     tree.newRight();
/*  52 */     tree.add(b.consumption(0.29D, 0, (Node)arrayListGrower4.last(), prev, "Piwa Excellence", "Decreases consumption when making Piwa."));
/*  53 */     tree.add(b.consumption(0.28D, 1, (Node)arrayListGrower4.last(), "Shedeh Excellence", "Decreases consumption when making Shedeh."));
/*     */     
/*  55 */     tree.newRight();
/*     */ 
/*     */ 
/*     */     
/*  59 */     tree.newRight();
/*     */ 
/*     */     
/*  62 */     b = new BuilderNode("COAL", "Charcoaler", "Charcoalers", "Charcoaling");
/*  63 */     b.addKey("REFINER_COALER", null);
/*  64 */     b.setToolLevel(0);
/*  65 */     b.setUpgrades(2);
/*  66 */     ArrayListGrower<Node> arrayListGrower3 = b.build(1.0D, new String[] { "32->REFINER->2" });
/*  67 */     tree.add((LIST<Node>)arrayListGrower3);
/*     */ 
/*     */     
/*  70 */     prev = null;
/*  71 */     tree.newRight();
/*  72 */     tree.add(b.consumption(0.37D, 0, (Node)arrayListGrower3.last(), prev, "Charcoaling Excellence", "Decreases consumption when making coal in the charcoaler."));
/*     */     
/*  74 */     tree.newRight();
/*     */ 
/*     */ 
/*     */     
/*  78 */     tree.newRight();
/*     */ 
/*     */     
/*  81 */     b = new BuilderNode("SMEL", "Smelter", "Smelters", "Metal Smelting");
/*  82 */     b.addKey("REFINER_SMELTER", null);
/*  83 */     b.setToolLevel(0);
/*  84 */     b.setUpgrades(2);
/*  85 */     ArrayListGrower<Node> arrayListGrower2 = b.build(1.0D, new String[] { "32->REFINER->3" });
/*  86 */     tree.add((LIST<Node>)arrayListGrower2);
/*     */ 
/*     */     
/*  89 */     prev = null;
/*  90 */     tree.newRight();
/*  91 */     tree.add(b.consumption(0.34D, 0, (Node)arrayListGrower2.last(), prev, "Smelting Excellence", "Decreases consumption when making metal in the smelter."));
/*     */     
/*  93 */     tree.newRight();
/*     */ 
/*     */ 
/*     */     
/*  97 */     tree.newRight();
/*     */ 
/*     */     
/* 100 */     b = new BuilderNode("WEAV", "Weaver", "Weavers", "Weaving Clothes");
/* 101 */     b.addKey("REFINER_WEAVER", null);
/* 102 */     b.setToolLevel(0);
/* 103 */     b.setUpgrades(2);
/* 104 */     ArrayListGrower<Node> arrayListGrower1 = b.build(1.0D, new String[] { "32->REFINER->4" });
/* 105 */     tree.add((LIST<Node>)arrayListGrower1);
/*     */ 
/*     */     
/* 108 */     prev = null;
/* 109 */     tree.newRight();
/* 110 */     tree.add(b.consumption(0.28D, 0, (Node)arrayListGrower1.last(), prev, "Weaving Excellence", "Decreases consumption when making fabric in the weaver."));
/*     */     
/* 112 */     tree.newRight();
/*     */ 
/*     */ 
/*     */     
/* 116 */     if (save) {
/* 117 */       tree.save(4, "32->_ICONS->13", "255_216_0", "Refining");
/*     */     }
/* 119 */     System.out.println(tree.build(0, "100_100_100", "32->TECH->13"));
/* 120 */     System.out.println(tree.buildText("workshops"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\GenRefine.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */