/*     */ package settlement.room.tests.production;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ public final class Production
/*     */ {
/*  14 */   private final Li all = new Li();
/*  15 */   private final Li[] resMap = new Li[RESOURCES.ALL().size()];
/*  16 */   private final Li[] insMap = new Li[Industry.all().size()];
/*     */ 
/*     */   
/*     */   public Production() {
/*  20 */     int[] industrycount = Alloc.ii(Industry.all().size());
/*     */     
/*  22 */     for (RESOURCE res : RESOURCES.ALL()) {
/*  23 */       this.resMap[res.index()] = new Li();
/*     */     }
/*     */ 
/*     */     
/*  27 */     Li all = new Li();
/*  28 */     for (Industry ins : Industry.all()) {
/*  29 */       this.insMap[ins.index()] = new Li();
/*  30 */       if (ins.outs().size() == 0)
/*     */         continue; 
/*  32 */       if (ins.blue instanceof settlement.room.food.hunter.ROOM_HUNTER) {
/*     */         continue;
/*     */       }
/*  35 */       for (IndustryResource o : ins.outs()) {
/*  36 */         industrycount[ins.index()] = industrycount[ins.index()] + 1; TestRecipe r = new TestRecipe(industrycount[ins.index()], ins, o);
/*  37 */         all.add(r);
/*  38 */         this.resMap[r.res.index()].add(r);
/*     */       } 
/*     */     } 
/*     */     
/*  42 */     for (TestRecipe r : all) {
/*  43 */       populateInputs(r, this.resMap, industrycount);
/*     */     }
/*     */     
/*  46 */     for (RESOURCE res : RESOURCES.ALL()) {
/*  47 */       this.all.add((Iterable)this.resMap[res.index()]);
/*     */     }
/*     */     
/*  50 */     for (TestRecipe r : all) {
/*  51 */       this.insMap[r.ins.index()].add(r);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void populateInputs(TestRecipe r, Li[] resMap, int[] industrycount) {
/*  57 */     for (IndustryResource in : r.ins.ins()) {
/*  58 */       for (TestRecipe prod : resMap[in.resource.index()]) {
/*  59 */         populateInputs(prod, resMap, industrycount);
/*     */       }
/*     */     } 
/*     */     
/*  63 */     if (r.inputs.size() > 0) {
/*     */       return;
/*     */     }
/*     */     
/*  67 */     for (IndustryResource in : r.ins.ins()) {
/*  68 */       Input input = new Input(in.rate, (TestRecipe)resMap[in.resource.index()].get(0));
/*  69 */       r.inputs.add(input);
/*     */     } 
/*     */     
/*  72 */     int extras = 1;
/*  73 */     for (IndustryResource in : r.ins.ins()) {
/*  74 */       extras *= resMap[in.resource.index()].size();
/*     */     }
/*     */     
/*  77 */     ArrayListGrower<TestRecipe> newRecs = new ArrayListGrower();
/*     */     
/*  79 */     for (int i = 1; i < extras; i++) {
/*  80 */       int k = i;
/*     */       
/*  82 */       ArrayListGrower<Input> inputs = new ArrayListGrower();
/*     */       
/*  84 */       for (IndustryResource in2 : r.ins.ins()) {
/*  85 */         int ri = k % resMap[in2.resource.index()].size();
/*     */         
/*  87 */         TestRecipe rr = (TestRecipe)resMap[in2.resource.index()].get(ri);
/*  88 */         inputs.add(new Input(in2.rate, rr));
/*     */         
/*  90 */         k /= resMap[in2.resource.index()].size();
/*     */       } 
/*     */       
/*  93 */       industrycount[r.ins.index()] = industrycount[r.ins.index()] + 1; TestRecipe res = new TestRecipe(industrycount[r.ins.index()], r);
/*  94 */       res.inputs.add((Iterable)inputs);
/*  95 */       newRecs.add(res);
/*     */     } 
/*     */     
/*  98 */     resMap[r.res.index()].add((Iterable)newRecs);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<TestRecipe> all() {
/* 103 */     return (LIST<TestRecipe>)this.all;
/*     */   }
/*     */   
/*     */   public LIST<TestRecipe> get(RESOURCE res) {
/* 107 */     return (LIST<TestRecipe>)this.resMap[res.index()];
/*     */   }
/*     */   
/*     */   public TestRecipe best(RESOURCE resource, ProductionSpec ibonuses) {
/* 111 */     LIST<TestRecipe> rs = get(resource);
/* 112 */     TestRecipe r = null;
/* 113 */     double best = Double.MAX_VALUE;
/* 114 */     for (int ri = 0; ri < rs.size(); ri++) {
/* 115 */       TestRecipe r2 = (TestRecipe)rs.get(ri);
/* 116 */       double w = r2.wPerItem(ibonuses);
/* 117 */       if (w < best) {
/* 118 */         best = w;
/* 119 */         r = r2;
/*     */       } 
/*     */     } 
/* 122 */     return r;
/*     */   }
/*     */   
/*     */   public LIST<TestRecipe> get(Industry res) {
/* 126 */     return (LIST<TestRecipe>)this.insMap[res.index()];
/*     */   }
/*     */   
/*     */   public double price(RESOURCE res, ProductionSpec ibonuses) {
/* 130 */     LIST<TestRecipe> rs = get(res);
/* 131 */     double min = Double.MAX_VALUE;
/*     */     
/* 133 */     for (TestRecipe rr : rs) {
/* 134 */       double t = rr.pricePerItem(ibonuses);
/* 135 */       if (t < min)
/*     */       {
/* 137 */         min = t;
/*     */       }
/*     */     } 
/* 140 */     return min;
/*     */   }
/*     */   
/*     */   private static class Li extends ArrayListGrower<TestRecipe> {
/*     */     private static final long serialVersionUID = 1L;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\production\Production.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */