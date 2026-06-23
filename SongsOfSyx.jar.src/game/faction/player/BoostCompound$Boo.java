/*     */ package game.faction.player;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.npc.FactionNPC;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Boo
/*     */   extends Booster
/*     */ {
/*     */   final Boostable bo;
/*  77 */   private int cacheI = -1000;
/*     */   private double cache;
/*     */   private final BValue value;
/*     */   private final double from;
/*     */   private final double to;
/*     */   private final double defV;
/*     */   
/*     */   public Boo(final LIST<BoostCompound<T>.Value> all) {
/*  85 */     super(paramBoostCompound.bos.info, ((BoostCompound.Value)all.get(0)).bo.booster.isMul);
/*  86 */     this.bo = ((BoostCompound.Value)all.get(0)).bo.boostable;
/*  87 */     this.defV = (((BoostCompound.Value)all.get(0)).bo.booster.isMul ? true : false);
/*  88 */     double from = 1.0D;
/*  89 */     double to = 1.0D;
/*  90 */     if (this.isMul) {
/*  91 */       for (BoostCompound<T>.Value v : all) {
/*  92 */         double d = v.bo.booster.getValue(1.0D);
/*  93 */         if (d < 1.0D) {
/*  94 */           from *= d; continue;
/*     */         } 
/*  96 */         to *= 1.0D + d;
/*     */       } 
/*     */     } else {
/*  99 */       from = 0.0D;
/* 100 */       to = 0.0D;
/* 101 */       for (BoostCompound<T>.Value v : all) {
/* 102 */         double d = v.bo.booster.getValue(1.0D);
/* 103 */         if (d < 0.0D) {
/* 104 */           from += d; continue;
/*     */         } 
/* 106 */         to += d;
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     this.from = from;
/* 111 */     this.to = to;
/*     */     
/* 113 */     this.value = (BValue)new BValue.BValueFaction(this.bo)
/*     */       {
/*     */         public double vGet(Player f)
/*     */         {
/* 117 */           int ci = GAME.updateI();
/* 118 */           if (ci != BoostCompound.Boo.this.cacheI) {
/* 119 */             BoostCompound.Boo.this.cacheI = GAME.updateI();
/* 120 */             BoostCompound.Boo.this.cache = 0.0D;
/* 121 */             if (BoostCompound.Boo.this.isMul) {
/* 122 */               for (BoostCompound<T>.Value v : all) {
/* 123 */                 BoostCompound.Boo.this.cache += v.bo.booster.getValue(BoostCompound.Boo.access$1(BoostCompound.Boo.this).getValue(v.t)) - 1.0D;
/*     */               }
/* 125 */               BoostCompound.Boo.this.cache++;
/* 126 */               BoostCompound.Boo.this.cache = Math.max(0.0D, BoostCompound.Boo.this.cache);
/*     */             } else {
/* 128 */               for (BoostCompound<T>.Value v : all) {
/* 129 */                 BoostCompound.Boo.this.cache += v.bo.booster.getValue(BoostCompound.Boo.access$1(BoostCompound.Boo.this).getValue(v.t));
/*     */               }
/*     */             } 
/*     */           } 
/* 133 */           return BoostCompound.Boo.this.cache;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/* 138 */           return BoostCompound.Boo.this.defV;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/* 148 */     return input;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(BOOSTABLE_O o) {
/* 153 */     return o.boostableValue(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public double from() {
/* 158 */     return this.from;
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/* 163 */     return this.to;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\BoostCompound$Boo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */