/*     */ package tools.techgen;
/*     */ 
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ 
/*     */ 
/*     */ class BuilderNode
/*     */ {
/*     */   public static final int MAX_POINTS = 500;
/*     */   public static final double MAX_BOOST = 6.0D;
/*     */   public static final double BOOST_PER_TOOL = 0.1875D;
/*     */   private static final int MAX_NODES = 4;
/*     */   private final String key;
/*  14 */   private ArrayListGrower<String> skeys = new ArrayListGrower();
/*  15 */   private ArrayListGrower<String> wkeys = new ArrayListGrower();
/*  16 */   private int upgrades = 0;
/*  17 */   private int toolLevels = 0;
/*  18 */   private int unlockCost = 0;
/*  19 */   public String iconFile = null;
/*     */   
/*     */   public final String sName;
/*     */   public final String sNames;
/*     */   public final String sVerb;
/*     */   
/*     */   BuilderNode(String key, String name, String names, String verb) {
/*  26 */     this.key = key;
/*  27 */     this.sName = name;
/*  28 */     this.sNames = names;
/*  29 */     this.sVerb = verb;
/*     */   }
/*     */   
/*     */   public BuilderNode setUpgrades(int upgrades) {
/*  33 */     this.upgrades = upgrades;
/*  34 */     return this;
/*     */   }
/*     */   
/*     */   public BuilderNode setUnlocks(int cost, String wKey) {
/*  38 */     this.unlockCost = cost;
/*  39 */     this.wkeys.add(wKey);
/*  40 */     return this;
/*     */   }
/*     */   
/*     */   public BuilderNode setUnlocks(int cost) {
/*  44 */     this.unlockCost = cost;
/*  45 */     return this;
/*     */   }
/*     */   
/*     */   public BuilderNode setToolLevel(int upgrades) {
/*  49 */     this.toolLevels = upgrades;
/*  50 */     return this;
/*     */   }
/*     */   
/*     */   public BuilderNode addKey(String sKey, String wKey) {
/*  54 */     this.skeys.add(sKey);
/*  55 */     if (wKey != null)
/*  56 */       this.wkeys.add(wKey); 
/*  57 */     return this;
/*     */   }
/*     */   
/*     */   public ArrayListGrower<Node> build(double costMul) {
/*  61 */     return build(costMul, 1.0D, new String[0]);
/*     */   }
/*     */   
/*     */   public ArrayListGrower<Node> build(double costMul, String... icons) {
/*  65 */     return build(costMul, 1.0D, icons);
/*     */   }
/*     */   
/*     */   public ArrayListGrower<Node> build(double costMul, double boMul, String... icons) {
/*  69 */     if (icons.length == 0)
/*  70 */       icons = null; 
/*  71 */     double[] costs = costs((int)Math.ceil(500.0D * costMul), 4);
/*  72 */     Node unlockNode = null;
/*     */     
/*  74 */     if (this.unlockCost > 0) {
/*  75 */       if (this.unlockCost >= costs[costs.length - 1])
/*  76 */         throw new RuntimeException(); 
/*  77 */       costs[costs.length - 1] = costs[costs.length - 1] - this.unlockCost;
/*  78 */       Node node = new Node(this.key + this.key);
/*  79 */       node.costInc(COST.CIVIC_INNOVATION, this.unlockCost);
/*  80 */       for (String str : this.skeys) {
/*  81 */         node.unlocksSett.add("ROOM_" + str);
/*     */       }
/*  83 */       node.unlocksWorld.add((Iterable)this.wkeys);
/*  84 */       node.name = "The " + this.sName;
/*  85 */       node.desc = "Unlocks the construction of the " + this.sName;
/*  86 */       if (icons != null) {
/*  87 */         node.icon = bakeIcon("32->TECH->6", icons);
/*     */       }
/*  89 */       unlockNode = node;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     int boostNodes = 4;
/*  97 */     int boostLevels = 10;
/*     */     
/*  99 */     double boPerLevel = boMul * 6.0D / 40.0D;
/* 100 */     double boRemain = 0.0D;
/*     */     
/* 102 */     ArrayListGrower<Node> bnodes = new ArrayListGrower();
/*     */     
/* 104 */     String[] names = {
/* 105 */         "Basic " + this.sVerb, "Skilled " + 
/* 106 */         this.sVerb, "Profficient " + 
/* 107 */         this.sVerb, "Expert " + 
/* 108 */         this.sVerb
/*     */       };
/*     */     
/* 111 */     for (int i = 0; i < 4; i++) {
/* 112 */       double d = costs[i] / 10.0D;
/* 113 */       Node nBoost = new Node(this.key + this.key);
/* 114 */       bnodes.add(nBoost);
/* 115 */       nBoost.costInc(COST.CIVIC_INNOVATION, (int)d);
/* 116 */       for (String str : this.skeys)
/* 117 */         nBoost.boost(("ROOM_" + str).replaceAll("__", "_") + ">ADD", boPerLevel); 
/* 118 */       nBoost.levels = 10;
/* 119 */       nBoost.name = names[i];
/* 120 */       nBoost.desc = "Improves the output of our " + this.sNames;
/* 121 */       if (icons != null) {
/*     */         
/* 123 */         String ir = bakeIcon("32->TECH->" + i, icons);
/* 124 */         nBoost.icon = ir;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     ArrayListGrower<Node> nodes = new ArrayListGrower();
/*     */ 
/*     */     
/* 132 */     Node bNode = (Node)bnodes.get(0);
/* 133 */     double cost = costs[0] / 10.0D;
/* 134 */     nodes.add(bNode);
/* 135 */     if (this.toolLevels / 2 > 0) {
/* 136 */       int tlevels = this.toolLevels / 2;
/* 137 */       double bo = 0.1875D * tlevels;
/* 138 */       int skipLevels = (int)Math.ceil(bo / boPerLevel);
/* 139 */       bNode.levels -= skipLevels;
/* 140 */       boRemain += skipLevels * boPerLevel - bo;
/* 141 */       Node n = new Node(this.key + "t1");
/* 142 */       nodes.add(n);
/* 143 */       for (String str : this.skeys)
/* 144 */         n.boost("EQUIP_LEVEL_TOOL_" + str + ">ADD", 1.0D); 
/* 145 */       n.costInc(COST.CIVIC_INNOVATION, (int)(skipLevels * cost / tlevels));
/* 146 */       n.levels = tlevels;
/* 147 */       n.name = this.sVerb + " Tools";
/* 148 */       n.desc = "Unlocks tools to be equipped for the " + this.sName + ". Tools must be manually equipped in the workplace.";
/* 149 */       if (icons != null) {
/* 150 */         n.icon = bakeIcon("32->TECH->7", icons);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 155 */     bNode = (Node)bnodes.get(1);
/* 156 */     cost = costs[1] / 10.0D;
/* 157 */     nodes.add(bNode);
/*     */     
/* 159 */     if (this.upgrades > 1) {
/*     */       
/* 161 */       double bo = boostUpgrade(1);
/* 162 */       int skipLevels = (int)Math.ceil(bo / boPerLevel);
/* 163 */       bNode.levels -= skipLevels;
/* 164 */       boRemain += skipLevels * boPerLevel - bo;
/* 165 */       Node n = new Node(this.key + "u1");
/* 166 */       nodes.add(n);
/* 167 */       for (String str : this.skeys)
/* 168 */         n.unlocksSett.add(("ROOM_" + str + "_UPGRADE_1").replaceAll("__", "_")); 
/* 169 */       n.costInc(COST.CIVIC_INNOVATION, (int)(skipLevels * cost));
/* 170 */       n.name = "Improved " + this.sName;
/* 171 */       n.desc = "Allows you to upgrade your " + this.sNames + ". Upgrades cost resources and increases maintenance cost.";
/* 172 */       if (icons != null) {
/* 173 */         n.icon = bakeIcon("32->TECH->4", icons);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 179 */     bNode = (Node)bnodes.get(2);
/* 180 */     cost = costs[2] / 10.0D;
/* 181 */     nodes.add(bNode);
/*     */     
/* 183 */     if (this.toolLevels > 2) {
/*     */       
/* 185 */       int tlevels = this.toolLevels / 2 + this.toolLevels % 2;
/* 186 */       double bo = 0.1875D * tlevels;
/* 187 */       int skipLevels = (int)Math.ceil(bo / boPerLevel);
/* 188 */       bNode.levels -= skipLevels;
/* 189 */       boRemain += skipLevels * boPerLevel - bo;
/* 190 */       Node n = new Node(this.key + "t2");
/* 191 */       nodes.add(n);
/* 192 */       for (String str : this.skeys)
/* 193 */         n.boost("EQUIP_LEVEL_TOOL_" + str + ">ADD", 1.0D); 
/* 194 */       n.costInc(COST.CIVIC_INNOVATION, (int)(skipLevels * cost / tlevels));
/* 195 */       n.levels = tlevels;
/* 196 */       n.name = "Advanced " + this.sVerb + " Tools";
/* 197 */       n.desc = "Unlocks tools to be equipped for the " + this.sName + ". Tools must be manually equipped in the workplace.";
/* 198 */       if (icons != null) {
/* 199 */         n.icon = bakeIcon("32->TECH->8", icons);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 205 */     bNode = (Node)bnodes.get(3);
/* 206 */     cost = costs[3] / 10.0D;
/* 207 */     nodes.add(bNode);
/*     */     
/* 209 */     if (this.upgrades > 0) {
/* 210 */       double bo = boostUpgrade(this.upgrades);
/* 211 */       int skipLevels = (int)Math.ceil(bo / boPerLevel);
/* 212 */       bNode.levels -= skipLevels;
/* 213 */       boRemain += skipLevels * boPerLevel - bo;
/* 214 */       Node n = new Node(this.key + "u2");
/* 215 */       nodes.add(n);
/* 216 */       for (String str : this.skeys)
/* 217 */         n.unlocksSett.add(("ROOM_" + str).replaceAll("__", "_") + ("ROOM_" + str).replaceAll("__", "_")); 
/* 218 */       n.costInc(COST.CIVIC_INNOVATION, (int)(skipLevels * cost));
/* 219 */       n.name = "Advanced " + this.sName;
/* 220 */       n.desc = "Allows you to upgrade your " + this.sNames + ". Upgrades cost resources and increases maintenance cost.";
/* 221 */       if (icons != null) {
/* 222 */         n.icon = bakeIcon("32->TECH->5", icons);
/*     */       }
/*     */     } 
/*     */     
/* 226 */     if (unlockNode != null) {
/* 227 */       ((Node)nodes.get(0)).require(unlockNode);
/*     */     }
/* 229 */     for (int j = 1; j < nodes.size(); j++) {
/* 230 */       ((Node)nodes.get(j)).require((Node)nodes.get(j - 1));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     ((Node)bnodes.get(bnodes.size() - 1)).boost.clear();
/* 242 */     for (String str : this.skeys) {
/* 243 */       ((Node)bnodes.get(bnodes.size() - 1)).boost(("ROOM_" + str).replaceAll("__", "_") + ">ADD", 
/* 244 */           boPerLevel + boRemain / ((Node)bnodes.get(bnodes.size() - 1)).levels);
/*     */     }
/* 246 */     ArrayListGrower<Node> res = new ArrayListGrower();
/* 247 */     if (unlockNode != null)
/* 248 */       res.add(unlockNode); 
/* 249 */     res.add((Iterable)nodes);
/*     */     
/* 251 */     int k = 0;
/* 252 */     for (Node n : res) {
/* 253 */       if (n != null && 
/* 254 */         this.iconFile != null) {
/* 255 */         n.icon = "32->" + this.iconFile + "->" + k++;
/*     */       }
/*     */       
/* 258 */       k++;
/*     */     } 
/*     */     
/* 261 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private String bakeIcon(String uu, String... icons) {
/* 266 */     String ir = "[ " + System.lineSeparator();
/* 267 */     JsonE[] js = new JsonE[icons.length];
/* 268 */     int ii = 0; byte b; int i; String[] arrayOfString;
/* 269 */     for (i = (arrayOfString = icons).length, b = 0; b < i; ) { String ico = arrayOfString[b];
/* 270 */       JsonE jsonE = new JsonE();
/* 271 */       jsonE.add("BG", ico);
/* 272 */       jsonE.add("SHADOW", 3);
/* 273 */       js[ii++] = jsonE;
/* 274 */       ir = ir + "{" + ir + System.lineSeparator() + jsonE.toString() + "}," + System.lineSeparator(); b++; }
/*     */     
/* 276 */     JsonE j = new JsonE();
/* 277 */     j.add("BG", uu);
/* 278 */     j.add("SHADOW", 3);
/* 279 */     ir = ir + "{" + ir + System.lineSeparator() + j.toString() + "}," + System.lineSeparator();
/* 280 */     ir = ir + "]";
/* 281 */     return ir;
/*     */   }
/*     */   
/*     */   public Node recipe(int cost, int rec, Node req, String name, String desc) {
/* 285 */     Node n = new Node(this.key + "r" + this.key);
/* 286 */     n.name = name;
/* 287 */     n.desc = desc;
/* 288 */     n.costInc(COST.CIVIC_INNOVATION, cost);
/* 289 */     if (req != null)
/* 290 */       n.require(req); 
/* 291 */     for (String k : this.skeys)
/* 292 */       n.unlocksSett.add("ROOM_" + k + "_RECIPE_" + rec); 
/* 293 */     return n;
/*     */   }
/*     */   
/*     */   public Node consumption(double amount, int rec, Node req, String name, String desc) {
/* 297 */     return consumption(amount, rec, req, null, name, desc);
/*     */   }
/*     */   
/*     */   public Node consumption(double amount, int rec, Node req, Node req2, String name, String desc) {
/* 301 */     Node n = new Node(this.key + "c" + this.key);
/* 302 */     n.name = name;
/* 303 */     n.desc = desc;
/* 304 */     n.costInc(COST.CIVIC_KNOWLEDGE, 35);
/*     */     
/* 306 */     n.levels = (int)Math.ceil(amount / 0.1D);
/* 307 */     if (req != null)
/* 308 */       n.require(req); 
/* 309 */     if (req2 != null)
/* 310 */       n.require(req2); 
/* 311 */     for (String k : this.skeys)
/* 312 */       n.boost("ROOM_CONSUMPTION_" + k + "_" + rec + ">ADD", 0.1D); 
/* 313 */     return n;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double[] costs(int maxPoints, int nodes) {
/* 319 */     double[] costs = new double[nodes];
/* 320 */     double factor = 5.0D;
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
/*     */     
/* 333 */     double startPoints = 2.0D * maxPoints / nodes * (factor + 1.0D);
/* 334 */     double inc = startPoints * (factor - 1.0D) / (nodes - 1);
/*     */     
/* 336 */     if (startPoints <= 0.0D || inc <= 0.0D) {
/* 337 */       throw new RuntimeException();
/*     */     }
/* 339 */     int sum = 0;
/* 340 */     for (int i = 0; i < nodes; i++) {
/* 341 */       costs[i] = (int)(startPoints + i * inc);
/* 342 */       sum = (int)(sum + costs[i]);
/*     */     } 
/*     */ 
/*     */     
/* 346 */     costs[nodes - 1] = costs[nodes - 1] + (maxPoints - sum);
/*     */ 
/*     */     
/* 349 */     return costs;
/*     */   }
/*     */   
/*     */   public static double boostUpgrade(int upi) {
/* 353 */     if (upi == 1)
/* 354 */       return 0.8D; 
/* 355 */     if (upi == 2)
/* 356 */       return 0.5D; 
/* 357 */     throw new RuntimeException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\BuilderNode.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */