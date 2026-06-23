/*     */ package world.region;
/*     */ 
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ public class RDProspects
/*     */ {
/*  16 */   private final ArrayList<II> all = new ArrayList(IndustryRegion.ALL().size());
/*     */   private boolean init = false;
/*     */   
/*     */   public RDProspects(RD.RDInit init) {
/*  20 */     for (IndustryRegion ii : IndustryRegion.ALL()) {
/*  21 */       this.all.add(new II(init, ii));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(Industry ins, Region reg) {
/*  30 */     return get(ins.reg(), reg);
/*     */   }
/*     */   
/*     */   public double get(IndustryRegion ins, Region reg) {
/*  34 */     if (reg == null)
/*  35 */       return 0.0D; 
/*  36 */     return ((II)this.all.get(ins.index)).data.getD(reg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean log = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void tt() {
/*  48 */     this.init = false;
/*  49 */     init();
/*     */   }
/*     */   
/*     */   private void init() {
/*  53 */     if (this.init)
/*     */       return; 
/*  55 */     this.init = true;
/*  56 */     for (II ii : this.all) {
/*  57 */       double am = 0.0D;
/*  58 */       for (Region reg : WORLD.REGIONS().active()) {
/*  59 */         am += ii.data.get(reg);
/*     */       }
/*  61 */       if (log)
/*  62 */         LOG.ln(ii.reg.ins.blue.key + " " + ii.reg.ins.blue.key + " " + ii.reg.rarity + " " + am); 
/*  63 */       am /= WORLD.REGIONS().active().size();
/*  64 */       ii.average = 1.0D / am;
/*     */     } 
/*     */     
/*  67 */     for (II ii : this.all) {
/*  68 */       double min = 2.147483647E9D;
/*  69 */       double max = 0.0D;
/*  70 */       double am = 0.0D;
/*  71 */       for (Region reg : WORLD.REGIONS().active()) {
/*  72 */         double a = getAi(ii.reg, reg);
/*  73 */         am += a;
/*  74 */         min = Math.min(a, min);
/*  75 */         max = Math.max(max, a);
/*     */       } 
/*     */       
/*  78 */       am /= WORLD.REGIONS().active().size();
/*  79 */       if (log)
/*  80 */         LOG.ln(ii.reg.ins.blue.key + " " + ii.reg.ins.blue.key + " " + am + " <-> " + min); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public double getAi(IndustryRegion ins, Region r) {
/*  85 */     if (ins == null)
/*  86 */       return 1.0D; 
/*  87 */     init();
/*  88 */     return 0.8D + 0.2D * ((II)this.all.get(ins.index)).data.get(r) * ((II)this.all.get(ins.index)).average;
/*     */   }
/*     */   
/*     */   private class II
/*     */   {
/*     */     private final INT_O.INT_OE<Region> data;
/*     */     private final IndustryRegion reg;
/*     */     private double average;
/*     */     
/*     */     II(RD.RDInit init, IndustryRegion reg) {
/*  98 */       this.data = (INT_O.INT_OE<Region>)new DataO.DataCrumb(init.count, "PROSPECT_" + reg.ins.blue.key);
/*  99 */       this.reg = reg;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void generate() {
/* 106 */     for (Region r : WORLD.REGIONS().all()) {
/* 107 */       for (II ii : this.all) {
/* 108 */         ii.data.set(r, 0);
/* 109 */         ii.average = 0.0D;
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     int regs = WORLD.REGIONS().active().size();
/*     */ 
/*     */     
/* 116 */     double amPerRegion = 2.0D;
/* 117 */     double tot = regs * amPerRegion;
/* 118 */     double rareTot = 0.0D;
/* 119 */     for (IndustryRegion ii : IndustryRegion.ALL()) {
/* 120 */       rareTot += ii.rarity;
/*     */     }
/*     */     
/* 123 */     int[] toAssign = Alloc.ii(IndustryRegion.ALL().size());
/* 124 */     int[] assigned = Alloc.ii(1023);
/*     */     
/* 126 */     for (int i = 3; i > 0; i--) {
/* 127 */       for (IndustryRegion ii : IndustryRegion.ALL()) {
/* 128 */         toAssign[ii.index] = (int)Math.ceil(tot * ii.rarity / rareTot);
/*     */       }
/*     */       do {
/*     */       
/* 132 */       } while (assign(toAssign, assigned, i));
/*     */     } 
/*     */ 
/*     */     
/* 136 */     for (II ii : this.all) {
/* 137 */       double am = 0.0D;
/* 138 */       for (Region reg : WORLD.REGIONS().active()) {
/* 139 */         am += ii.data.get(reg);
/*     */       }
/*     */       
/* 142 */       am /= WORLD.REGIONS().active().size();
/* 143 */       ii.average = am;
/*     */     } 
/*     */     
/* 146 */     this.init = false;
/* 147 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean assign(int[] toAssign, int[] assigned, int value) {
/* 153 */     boolean a = false;
/* 154 */     for (IndustryRegion ii : IndustryRegion.ALL()) {
/* 155 */       if (toAssign[ii.index] > 0) {
/*     */ 
/*     */         
/* 158 */         Region best = null;
/* 159 */         double bv = Double.NEGATIVE_INFINITY;
/*     */         
/* 161 */         for (Region reg : WORLD.REGIONS().active()) {
/*     */           
/* 163 */           if (reg != (WORLD.REGIONS()).player && ((II)this.all.get(ii.index)).data.get(reg) == 0) {
/* 164 */             double v = ii.occurence(reg) / (1.0D + assigned[reg.index()]);
/* 165 */             if (v > bv) {
/*     */               
/* 167 */               bv = v;
/* 168 */               best = reg;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 173 */         if (best != null) {
/* 174 */           ((II)this.all.get(ii.index)).data.set(best, value);
/* 175 */           toAssign[ii.index] = toAssign[ii.index] - 1;
/* 176 */           assigned[best.index()] = assigned[best.index()] + 1;
/* 177 */           a = true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 181 */     return a;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDProspects.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */