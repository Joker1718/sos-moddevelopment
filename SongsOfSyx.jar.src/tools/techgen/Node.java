/*     */ package tools.techgen;
/*     */ 
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tuple;
/*     */ 
/*     */ class Node {
/*  10 */   public String name = "";
/*  11 */   public String desc = "";
/*     */   
/*     */   public final String key;
/*  14 */   public int levels = 1;
/*  15 */   public int[] cost = Alloc.ii((COST.values()).length);
/*  16 */   public int costKnowledge = 0;
/*  17 */   public int costAdmin = 0;
/*  18 */   public int costInc = 0;
/*  19 */   public final ArrayListGrower<String> unlocksWorld = new ArrayListGrower();
/*  20 */   public final ArrayListGrower<String> unlocksSett = new ArrayListGrower();
/*  21 */   public final ArrayListGrower<Tuple.TupleImp<String, Integer>> requireTech = new ArrayListGrower();
/*  22 */   public final ArrayListGrower<Tuple.TupleImp<String, Integer>> requireGreater = new ArrayListGrower();
/*  23 */   public final ArrayListGrower<Tuple.TupleImp<String, Double>> boost = new ArrayListGrower();
/*  24 */   public String icon = null;
/*     */ 
/*     */   
/*     */   Node(String key) {
/*  28 */     this.key = key;
/*     */   }
/*     */ 
/*     */   
/*     */   public void requireG(String key, int value) {
/*  33 */     this.requireGreater.add(new Tuple.TupleImp(key, Integer.valueOf(value)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void require(String key, int value) {
/*  38 */     this.requireTech.add(new Tuple.TupleImp(key, Integer.valueOf(value)));
/*     */   }
/*     */   
/*     */   public void require(Node node) {
/*  42 */     require(node.key, node.levels);
/*     */   }
/*     */   
/*     */   public void boost(String key, double value) {
/*  46 */     this.boost.add(new Tuple.TupleImp(key, Double.valueOf(value)));
/*     */   }
/*     */   
/*     */   public void costInc(COST c, int am) {
/*  50 */     this.cost[c.ordinal()] = this.cost[c.ordinal()] + am;
/*     */   }
/*     */   
/*     */   public JsonE json() {
/*  54 */     JsonE j = new JsonE();
/*  55 */     if (this.icon != null) {
/*  56 */       j.add("ICON", this.icon);
/*     */     }
/*  58 */     j.add("LEVEL_MAX", this.levels);
/*  59 */     if (this.costInc > 0)
/*  60 */       j.add("LEVEL_COST_INC", this.costInc); 
/*  61 */     JsonE c = new JsonE(); byte b; int i; COST[] arrayOfCOST;
/*  62 */     for (i = (arrayOfCOST = COST.values()).length, b = 0; b < i; ) { COST co = arrayOfCOST[b];
/*  63 */       if (this.cost[co.ordinal()] > 0)
/*  64 */         c.add(co.name(), this.cost[co.ordinal()]); 
/*     */       b++; }
/*     */     
/*  67 */     j.add("COSTS", c);
/*     */     
/*  69 */     if (this.requireTech.size() > 0) {
/*  70 */       JsonE r = new JsonE();
/*  71 */       for (Tuple.TupleImp<String, Integer> t : this.requireTech) {
/*  72 */         r.add((String)t.a, ((Integer)t.b).intValue());
/*     */       }
/*  74 */       j.add("REQUIRES_TECH_LEVEL", r);
/*     */     } 
/*     */     
/*  77 */     if (this.requireGreater.size() > 0) {
/*  78 */       JsonE r = new JsonE();
/*  79 */       for (Tuple.TupleImp<String, Integer> t : this.requireGreater) {
/*  80 */         r.add((String)t.a, ((Integer)t.b).intValue());
/*     */       }
/*  82 */       JsonE rr = new JsonE();
/*  83 */       rr.add("GREATER", r);
/*  84 */       j.add("REQUIRES", rr);
/*     */     } 
/*     */     
/*  87 */     if (this.boost.size() > 0) {
/*  88 */       JsonE e = new JsonE();
/*  89 */       for (Tuple.TupleImp<String, Double> t : this.boost) {
/*  90 */         double bo = ((Double)t.b).doubleValue();
/*  91 */         bo = (int)(bo * 100.0D) / 100.0D;
/*  92 */         e.add((String)t.a, bo);
/*     */       } 
/*  94 */       j.add("BOOST", e);
/*     */     } 
/*     */     
/*  97 */     if (this.unlocksWorld.size() > 0)
/*  98 */       j.add("UNLOCKS_REGION", (LIST)this.unlocksWorld); 
/*  99 */     if (this.unlocksSett.size() > 0) {
/* 100 */       j.add("UNLOCKS_FACTION", (LIST)this.unlocksSett);
/*     */     }
/* 102 */     return j;
/*     */   }
/*     */   
/*     */   public JsonE text() {
/* 106 */     JsonE j = new JsonE();
/* 107 */     j.addString("NAME", this.name);
/* 108 */     j.addString("DESC", this.desc);
/* 109 */     return j;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\Node.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */