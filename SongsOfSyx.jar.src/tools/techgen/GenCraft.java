/*     */ package tools.techgen;
/*     */ 
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ class GenCraft
/*     */ {
/*     */   GenCraft(boolean save) {
/*  11 */     BuilderTree tree = new BuilderTree("WORKSHOP");
/*     */ 
/*     */     
/*  14 */     BuilderNode b = new BuilderNode("CRPT", "Carpenter", "Carpenters", "Carpentry");
/*  15 */     b.addKey("WORKSHOP_CARPENTER", null);
/*  16 */     b.setToolLevel(4);
/*  17 */     b.setUpgrades(1);
/*  18 */     ArrayListGrower<Node> arrayListGrower10 = b.build(2.5D);
/*  19 */     tree.add((LIST<Node>)arrayListGrower10);
/*     */ 
/*     */     
/*  22 */     Node prev = null;
/*  23 */     tree.newRight();
/*     */     
/*  25 */     prev = tree.add(b.recipe(2, 1, null, "Makeshift Spears", "Unlocks simple, crude Spear production."));
/*     */     
/*  27 */     tree.add(b.consumption(2.2D, 1, (Node)arrayListGrower10.last(), prev, "Obsidian Spear Excellence", "Decreases Consumption of input materials when producing stone spears."));
/*     */ 
/*     */     
/*  30 */     tree.skip(2);
/*  31 */     tree.add(b.consumption(0.26D, 2, (Node)arrayListGrower10.last(), "Spear crafting Excellence", "Decreases Consumption of input materials when producing spears."));
/*  32 */     tree.add(b.consumption(0.32D, 4, (Node)arrayListGrower10.last(), "Shield crafting Excellence", "Decreases Consumption of input materials when producing shields."));
/*  33 */     tree.add(b.consumption(0.4D, 0, (Node)arrayListGrower10.last(), null, "Furniture Excellence", "Decreases Consumption of input materials when producing furniture."));
/*     */     
/*  35 */     tree.newRight();
/*  36 */     prev = tree.add(b.recipe(2, 3, null, "Makeshift Battle-Hammers", "Unlocks production of simple, crude hammers of stone instead of metal."));
/*     */     
/*  38 */     tree.add(b.consumption(1.14D, 3, (Node)arrayListGrower10.last(), prev, "Stone Hammer Excellence", "Decreases Consumption of input materials when producing stone hammers."));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     tree.newRight();
/*     */     
/*  45 */     tree.newRight();
/*  46 */     tree.newRight();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     b = new BuilderNode("SMIT", "Smithy", "Smithies", "Forging");
/*  53 */     b.addKey("WORKSHOP_SMITHY", null);
/*  54 */     b.setToolLevel(8);
/*  55 */     b.setUpgrades(0);
/*  56 */     ArrayListGrower<Node> arrayListGrower9 = b.build(4.0D);
/*  57 */     tree.add((LIST<Node>)arrayListGrower9);
/*  58 */     tree.add(b.consumption(0.27D, 0, (Node)arrayListGrower9.last(), "Tool Excellence", "Decreases Consumption of input materials when producing tools."));
/*     */     
/*  60 */     prev = null;
/*     */     
/*  62 */     tree.newRight();
/*  63 */     tree.skip(0);
/*  64 */     prev = tree.add(b.recipe(20, 2, null, "Falcata", "Unlocks production of the Falcata. A short range weapon, meant for close and prolonged combat."));
/*  65 */     tree.add(b.consumption(0.29D, 2, (Node)arrayListGrower9.last(), prev, "Falcata Excellence", "Decreases Consumption of input materials when producing falcatas."));
/*     */     
/*  67 */     tree.newRight();
/*  68 */     tree.skip(0);
/*  69 */     prev = tree.add(b.recipe(15, 3, null, "Flanx", "Unlocks production of the mighty Flanx. A devastating, two-handed weapon used to slash your way through enemy formations."));
/*  70 */     tree.add(b.consumption(0.3D, 3, (Node)arrayListGrower9.last(), prev, "Flanx Excellence", "Decreases Consumption of input materials when producing Flanxes."));
/*     */     
/*  72 */     tree.newRight();
/*  73 */     tree.skip(0);
/*  74 */     prev = tree.add(b.recipe(10, 4, null, "Warhammers", "Unlocks production of warhammers. A crude, but effective weapon if in the hands of a strong hands/claws."));
/*  75 */     tree.add(b.consumption(0.31D, 4, (Node)arrayListGrower9.last(), prev, "Warhammer Excellence", "Decreases Consumption of input materials when producing war hammers."));
/*     */ 
/*     */     
/*  78 */     tree.newRight();
/*  79 */     tree.skip(1);
/*  80 */     prev = tree.add(b.recipe(6, 1, (Node)arrayListGrower9.get(0), "Full Plate", "Unlocks full Plate armour."));
/*  81 */     tree.add(b.consumption(0.3D, 1, (Node)arrayListGrower9.last(), prev, "Full Plate Excellence", "Decreases Consumption of input materials when producing plate armour."));
/*     */     
/*  83 */     tree.newRight();
/*     */ 
/*     */     
/*  86 */     tree.newRight();
/*     */ 
/*     */     
/*  89 */     b = new BuilderNode("POTT", "Pottery", "Potteries", "Pot Making");
/*  90 */     b.addKey("WORKSHOP_POTTERY", null);
/*  91 */     b.setToolLevel(8);
/*  92 */     b.setUpgrades(0);
/*  93 */     ArrayListGrower<Node> arrayListGrower8 = b.build(1.0D);
/*  94 */     tree.add((LIST<Node>)arrayListGrower8);
/*  95 */     tree.add(b.consumption(0.27D, 0, (Node)arrayListGrower8.last(), "Pottery Excellence", "Decreases Consumption of input materials when producing pottery."));
/*  96 */     tree.newRight();
/*     */ 
/*     */     
/*  99 */     tree.newRight();
/*     */ 
/*     */     
/* 102 */     b = new BuilderNode("TAIL", "Tailor", "Tailors", "Tailoring");
/* 103 */     b.addKey("WORKSHOP_TAILOR", null);
/* 104 */     b.setToolLevel(4);
/* 105 */     b.setUpgrades(1);
/* 106 */     ArrayListGrower<Node> arrayListGrower7 = b.build(2.0D);
/* 107 */     tree.add((LIST<Node>)arrayListGrower7);
/*     */     
/* 109 */     tree.newRight();
/* 110 */     tree.skip(4);
/*     */     
/* 112 */     tree.add(b.consumption(1.28D, 0, (Node)arrayListGrower7.last(), "Leather Excellence", "Decreases Consumption of input materials when producing leather clothes."));
/* 113 */     tree.add(b.consumption(0.27D, 1, (Node)arrayListGrower7.last(), "Fabric excellence", "Decreases Consumption of input materials when producing fabric clothes."));
/* 114 */     tree.add(b.consumption(0.28D, 2, (Node)arrayListGrower7.last(), "Leather Armour Excellence", "Decreases Consumption of input materials when producing leather armour."));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     tree.newLevel();
/* 122 */     tree.newLine();
/*     */ 
/*     */     
/* 125 */     b = new BuilderNode("RATI", "Rationmaker", "Rationmakers", "Ration making");
/* 126 */     b.addKey("WORKSHOP_RATION", null);
/* 127 */     b.setToolLevel(4);
/* 128 */     b.setUpgrades(1);
/* 129 */     ArrayListGrower<Node> arrayListGrower6 = b.build(1.0D);
/* 130 */     tree.add((LIST<Node>)arrayListGrower6);
/*     */ 
/*     */     
/* 133 */     tree.newRight();
/* 134 */     tree.skip(1);
/*     */     
/* 136 */     tree.add(b.consumption(2.48D, 0, (Node)arrayListGrower6.last(), "Dry biscuit Excellence", "Decreases Consumption of input materials when producing rations with only bread."));
/* 137 */     tree.add(b.consumption(0.28D, 1, (Node)arrayListGrower6.last(), "Biscuit Excellence", "Decreases Consumption of input materials when producing bread and herb rations."));
/* 138 */     tree.add(b.consumption(0.71D, 2, (Node)arrayListGrower6.last(), "Jerky Excellence", "Decreases Consumption of input materials when meat rations."));
/* 139 */     tree.add(b.consumption(0.46D, 3, (Node)arrayListGrower6.last(), "Pemmican Excellence", "Decreases Consumption of input materials when producing fish rations."));
/* 140 */     tree.add(b.consumption(0.41D, 4, (Node)arrayListGrower6.last(), "Concervation Excellence", "Decreases Consumption of input materials when producing fruit rations."));
/* 141 */     tree.add(b.consumption(0.5D, 5, (Node)arrayListGrower6.last(), "Pickling Excellence", "Decreases Consumption of input materials when producing vegitable rations."));
/* 142 */     tree.newRight();
/*     */ 
/*     */     
/* 145 */     tree.newRight();
/*     */ 
/*     */     
/* 148 */     b = new BuilderNode("BOWY", "Bowyer", "Bowyers", "Bow making");
/* 149 */     b.addKey("WORKSHOP_BOWYER", null);
/* 150 */     b.setToolLevel(8);
/* 151 */     b.setUpgrades(0);
/* 152 */     b.setUnlocks(15);
/*     */     
/* 154 */     ArrayListGrower<Node> arrayListGrower5 = b.build(1.0D);
/* 155 */     tree.add((LIST<Node>)arrayListGrower5);
/* 156 */     tree.add(b.consumption(0.33D, 0, (Node)arrayListGrower5.last(), "War Bow Excellence", "Decreases Consumption of input materials when producing bows."));
/* 157 */     tree.newRight();
/*     */ 
/*     */     
/* 160 */     tree.newRight();
/*     */ 
/*     */     
/* 163 */     b = new BuilderNode("PAPE", "Papermaker", "Papermakers", "Paper making");
/* 164 */     b.addKey("WORKSHOP_PAPER", null);
/* 165 */     b.setToolLevel(8);
/* 166 */     b.setUpgrades(0);
/* 167 */     b.setUnlocks(15);
/* 168 */     ArrayListGrower<Node> arrayListGrower4 = b.build(1.0D);
/* 169 */     tree.add((LIST<Node>)arrayListGrower4);
/* 170 */     tree.add(b.consumption(0.37D, 0, (Node)arrayListGrower4.last(), "Paper Excellence", "Decreases Consumption of input materials when producing paper."));
/* 171 */     tree.newRight();
/*     */ 
/*     */     
/* 174 */     tree.newRight();
/*     */ 
/*     */     
/* 177 */     b = new BuilderNode("MASO", "Masonry", "Masonries", "Stone sculpting");
/* 178 */     b.addKey("WORKSHOP_MASON", null);
/* 179 */     b.setToolLevel(8);
/* 180 */     b.setUpgrades(0);
/* 181 */     b.setUnlocks(15);
/* 182 */     ArrayListGrower<Node> arrayListGrower3 = b.build(1.0D);
/* 183 */     tree.add((LIST<Node>)arrayListGrower3);
/* 184 */     tree.add(b.consumption(0.4D, 0, (Node)arrayListGrower3.last(), "Stone Sculpting Excellence", "Decreases Consumption of input materials when producing cut stone."));
/* 185 */     tree.newRight();
/*     */ 
/*     */     
/* 188 */     tree.newRight();
/*     */ 
/*     */     
/* 191 */     b = new BuilderNode("MECH", "Mechanic", "Mechanics", "Machine making");
/* 192 */     b.addKey("WORKSHOP_MECHANIC", null);
/* 193 */     b.setToolLevel(8);
/* 194 */     b.setUpgrades(0);
/* 195 */     b.setUnlocks(50);
/* 196 */     ArrayListGrower<Node> arrayListGrower2 = b.build(1.0D);
/* 197 */     tree.add((LIST<Node>)arrayListGrower2);
/* 198 */     tree.add(b.consumption(0.26D, 0, (Node)arrayListGrower2.last(), "Machinery Excellence", "Decreases Consumption of input materials when producing machinery."));
/* 199 */     tree.newRight();
/*     */ 
/*     */     
/* 202 */     tree.newRight();
/*     */ 
/*     */     
/* 205 */     b = new BuilderNode("JEWE", "Jeweller", "Jewellers", "Jewellery Making");
/* 206 */     b.addKey("WORKSHOP_JEWELRY", null);
/* 207 */     b.setToolLevel(8);
/* 208 */     b.setUpgrades(0);
/* 209 */     b.setUnlocks(20);
/* 210 */     ArrayListGrower<Node> arrayListGrower1 = b.build(1.0D);
/* 211 */     tree.add((LIST<Node>)arrayListGrower1);
/* 212 */     tree.add(b.consumption(0.26D, 0, (Node)arrayListGrower1.last(), "Jewellery Excellence", "Decreases Consumption of input materials when producing jewellery."));
/* 213 */     tree.newRight();
/*     */ 
/*     */     
/* 216 */     tree.newLevel();
/*     */ 
/*     */ 
/*     */     
/* 220 */     if (save) {
/* 221 */       tree.save(5, "32->_ICONS->14", "192_192_192", "Crafting");
/*     */     }
/* 223 */     System.out.println(tree.build(0, "100_100_100", "32->ICON->14"));
/* 224 */     System.out.println(tree.buildText("workshops"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\GenCraft.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */