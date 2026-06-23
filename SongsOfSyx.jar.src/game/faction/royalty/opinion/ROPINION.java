/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.superb.SuperBoostable;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.value.GVALUES;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.text.D;
/*     */ 
/*     */ public class ROPINION {
/*  18 */   public static CharSequence ¤¤name = "Opinion"; static ROPINION self;
/*  19 */   public static CharSequence ¤¤desc = "The opinion of a royalty regarding you. High opinion yields better diplomacy and allows for higher stances. Falling below the minimum threshold of opinion of your current stance might lead to the faction breaking it off.";
/*  20 */   public static CharSequence ¤¤wEmmi = "Emissary Target"; private final OpsStance stance;
/*     */   
/*     */   static {
/*  23 */     D.ts(ROPINION.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final OpsGifts gifts;
/*     */   private final OpsEmi emi;
/*     */   private final OpsOther other;
/*     */   private final RTrust trust;
/*     */   
/*     */   public ROPINION(FACTIONS factions) {
/*  33 */     self = this;
/*     */     
/*  35 */     this.stance = new OpsStance();
/*  36 */     this.gifts = new OpsGifts();
/*  37 */     this.emi = new OpsEmi();
/*  38 */     this.other = new OpsOther();
/*     */     
/*  40 */     GVALUES.FACTION.push("OPINION", ¤¤name, (SPRITE)(BOOSTABLES.CIVICS()).bOpinion.icon, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  44 */             if (t instanceof FactionNPC) {
/*  45 */               return ROPINION.get((FactionNPC)t);
/*     */             }
/*  47 */             return 0.0D;
/*     */           }
/*     */         });
/*     */     
/*  51 */     this.trust = new RTrust(factions);
/*     */   }
/*     */   
/*     */   public static SuperBoostable<Royalty> BOOST() {
/*  55 */     return (GAME.BOOSTS()).OPINION;
/*     */   }
/*     */   
/*     */   public static OpsStance STANCE() {
/*  59 */     return self.stance;
/*     */   }
/*     */   
/*     */   public static OpsGifts GIFTS() {
/*  63 */     return self.gifts;
/*     */   }
/*     */   
/*     */   public static OpsEmi EMMI() {
/*  67 */     return self.emi;
/*     */   }
/*     */   
/*     */   public static OpsOther OTHER() {
/*  71 */     return self.other;
/*     */   }
/*     */   
/*     */   public static double get(FactionNPC f) {
/*  75 */     if (f != null && f.court().king() != null)
/*  76 */       return get(f.court().king().roy()); 
/*  77 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public static double get(Royalty roy) {
/*  81 */     return BOOST().get((SuperBoostableObj)roy);
/*     */   }
/*     */   
/*     */   public static RTrust trust() {
/*  85 */     return self.trust;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double get(FactionNPC f, ROpper op, double opValue) {
/*  90 */     double old = op.value.getD(f.king());
/*  91 */     op.value.setD(f.king(), opValue);
/*  92 */     double res = get(f);
/*  93 */     op.value.setD(f.king(), old);
/*  94 */     return res;
/*     */   }
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
/*     */   static double getPeaceValue(FactionNPC f, ROpper op, double targetValue) {
/* 113 */     return getOpinionValue(RTrust.BOOST(), f, op, targetValue);
/*     */   }
/*     */ 
/*     */   
/*     */   static void setOpinionValue(FactionNPC f, ROpper op, double targetValue) {
/* 118 */     double v = getOpinionValue(f, op, targetValue);
/* 119 */     for (Royalty roy : f.court().all()) {
/* 120 */       op.value.setD(roy, (roy == f.king()) ? v : (v * 0.5D));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static double getOpinionValue(FactionNPC f, ROpper op, double targetValue) {
/* 126 */     return getOpinionValue(BOOST(), f, op, targetValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static double getOpinionValue(SuperBoostable<Royalty> bo, FactionNPC f, ROpper op, double targetValue) {
/* 132 */     Royalty k = f.king();
/* 133 */     double o = op.value.getD(k);
/* 134 */     op.value.setD(k, 0.0D);
/*     */     
/* 136 */     if (op.to() > 0.0D) {
/* 137 */       if (bo.get((SuperBoostableObj)k) > targetValue) {
/* 138 */         op.value.setD(k, o);
/* 139 */         return 0.0D;
/*     */       } 
/*     */       
/* 142 */       double inc = 1.0D;
/*     */       
/* 144 */       while (bo.get((SuperBoostableObj)k) < targetValue) {
/* 145 */         double prev = bo.get((SuperBoostableObj)k);
/* 146 */         op.value.incD(k, inc);
/* 147 */         if (prev == bo.get((SuperBoostableObj)k))
/*     */           break; 
/* 149 */         if (bo.get((SuperBoostableObj)k) > targetValue) {
/* 150 */           op.value.incD(k, -inc);
/* 151 */           inc /= 2.0D;
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 156 */       if (bo.get((SuperBoostableObj)k) < targetValue) {
/* 157 */         op.value.setD(k, o);
/* 158 */         return 0.0D;
/*     */       } 
/*     */       
/* 161 */       double inc = 1.0D;
/*     */       
/* 163 */       while (bo.get((SuperBoostableObj)k) > targetValue) {
/* 164 */         double prev = get(f);
/* 165 */         op.value.incD(k, inc);
/* 166 */         if (prev == bo.get((SuperBoostableObj)k))
/*     */           break; 
/* 168 */         if (bo.get((SuperBoostableObj)k) < targetValue) {
/* 169 */           op.value.incD(k, -inc);
/* 170 */           inc /= 2.0D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 176 */     double v = op.value.getD(k);
/* 177 */     op.value.setD(k, o);
/* 178 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double tradeCost(FactionNPC f) {
/* 183 */     return (DIP.get(f)).tarif;
/*     */   }
/*     */   
/*     */   public static void trade(FactionNPC f, int price) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\ROPINION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */