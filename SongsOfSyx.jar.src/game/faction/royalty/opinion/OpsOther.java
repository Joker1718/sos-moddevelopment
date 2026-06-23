/*     */ package game.faction.royalty.opinion;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.time.TIME;
/*     */ import game.tourism.TOURISM;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public final class OpsOther {
/*  23 */   private static CharSequence ¤¤liberation = "Liberation";
/*  24 */   private static CharSequence ¤¤liberationD = "Affection from previous liberation of this faction.";
/*     */   
/*  26 */   private static CharSequence ¤¤vassalT = "Vassal Tribute";
/*  27 */   private static CharSequence ¤¤vassalTD = "Based on the number of gifts that have been declined.";
/*     */ 
/*     */   
/*  30 */   private static CharSequence ¤¤proximity = "Nearness";
/*  31 */   private static CharSequence ¤¤proximityD = "Based on the distance to this faction, capitol to capitol.";
/*     */   
/*  33 */   private static CharSequence ¤¤kinship = "Kinship";
/*  34 */   private static CharSequence ¤¤kinshipD = "Based on your race and this royalties race.";
/*     */   
/*  36 */   private static CharSequence ¤¤kinshipT = "Kin Treatment";
/*  37 */   private static CharSequence ¤¤kinshipTD = "How you are treating this royalty's race and its affiliated races.";
/*     */   
/*  39 */   private static CharSequence ¤¤poison = "Rumours";
/*  40 */   private static CharSequence ¤¤PosionD = "Rumours about you spread by deceitful factions.";
/*     */   
/*     */   public final ROpper.ROpperDown liberation;
/*     */   public final ROpper proximity;
/*     */   public final ROpper vassalTribute;
/*     */   public final ROpper kinship;
/*     */   public final ROpper kintreatment;
/*     */   public final ROpper poison;
/*     */   
/*     */   static {
/*  50 */     D.ts(OpsOther.class);
/*     */   }
/*     */   
/*     */   OpsOther() {
/*  54 */     final double year = (TIME.secondsPerDay() * 16);
/*  55 */     this.liberation = new ROpper.ROpperDown("LIBERATION", ¤¤liberation, ¤¤liberationD, (SPRITE)(UI.icons()).s.flags, 4.0D, false, year * 5.0D);
/*     */     
/*  57 */     this.proximity = new ROpper("PROXI", ¤¤proximity, ¤¤proximityD, (SPRITE)(UI.icons()).s.wheel, 1.0D, false)
/*     */       {
/*     */         public double pget(Royalty roy)
/*     */         {
/*  61 */           return 1.0D - CLAMP.d(RD.DIST().capitolDist(roy.court.faction) / 256.0D, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/*  66 */           return pget(bo);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  71 */     this.poison = new ROpper("POSION", ¤¤poison, ¤¤PosionD, (SPRITE)(UI.icons()).s.death, -20.0D, false)
/*     */       {
/*     */         public double increase(Royalty roy)
/*     */         {
/*  75 */           return -1.0D / year * 2.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double getModifier(Royalty roy) {
/*  81 */           return 1.0D - 0.5D * (BOOSTABLES.NOBLE()).HONOUR.get((BOOSTABLE_O)roy.induvidual);
/*     */         }
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/*  86 */           return 0.0D;
/*     */         }
/*     */       };
/*     */     
/*  90 */     this.vassalTribute = new ROpper("VASSAL_GIFT", ¤¤vassalT, ¤¤vassalTD, (SPRITE)(UI.icons()).s.gift, 3.0D, false)
/*     */       {
/*     */         
/*     */         public double pget(Royalty bo)
/*     */         {
/*  95 */           Royalty roy = bo;
/*  96 */           if (DIP.overlord((Faction)roy.court.faction) == FACTIONS.player()) {
/*  97 */             return super.pget(bo);
/*     */           }
/*  99 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/* 104 */           return 0.0D;
/*     */         }
/*     */       };
/*     */     
/* 108 */     this.kinship = new ROpper("KINSHIP", ¤¤kinship, ¤¤kinshipD, (SPRITE)(UI.icons()).s.human, 0.75D, true)
/*     */       {
/*     */ 
/*     */         
/*     */         public double getModifier(Royalty roy)
/*     */         {
/* 114 */           return (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)roy.induvidual);
/*     */         }
/*     */ 
/*     */         
/*     */         public double pget(Royalty roy) {
/* 119 */           double d = roy.induvidual.race().pref().race(FACTIONS.player().race());
/* 120 */           d = 1.0D - CLAMP.d(d, 0.0D, 1.0D);
/* 121 */           return d;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/* 126 */           return pget(bo);
/*     */         }
/*     */       };
/*     */     
/* 130 */     this.kintreatment = new ROpper("KIN_TREATMENT", ¤¤kinshipT, ¤¤kinshipTD, (SPRITE)(UI.icons()).s.human, 0.5D, true)
/*     */       {
/*     */         public double getModifier(Royalty roy)
/*     */         {
/* 134 */           return 1.0D - 0.5D * (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)roy.induvidual);
/*     */         }
/*     */ 
/*     */         
/*     */         public double pget(Royalty roy) {
/* 139 */           double c = 0.0D;
/* 140 */           Race ra = roy.induvidual.race();
/* 141 */           c += (STATS.MULTIPLIERS()).PROSECUTION.value(HCLASSES.CITIZEN(), ra, 0);
/* 142 */           c += (20 * POP.tot(HCLASSES.SLAVE(), ra) / (1 + POP.tot(null, null)));
/* 143 */           RDRace rr = RD.RACE(ra);
/* 144 */           if (rr != null) {
/* 145 */             c += (RD.RACES()).edicts.sanction.realm(rr).getD(FACTIONS.player()) * 0.25D;
/* 146 */             c += (RD.RACES()).edicts.exile.realm(rr).getD(FACTIONS.player()) * 0.5D;
/* 147 */             c += (RD.RACES()).edicts.massacre.realm(rr).getD(FACTIONS.player());
/*     */           } 
/*     */           
/* 150 */           if (!TOURISM.permit(ra)) {
/* 151 */             c += 0.1D;
/*     */           }
/*     */           
/* 154 */           c = CLAMP.d(c, 0.0D, 1.0D);
/* 155 */           return c;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/* 160 */           return 0.0D;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void liberate(FactionNPC f) {
/* 169 */     for (Royalty r : f.court().all()) {
/* 170 */       this.liberation.value.setD(r, r.isKing() ? 1.0D : 0.5D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void acceptTribute(FactionNPC f, boolean accept) {
/* 176 */     double v = this.vassalTribute.value.getD(f.king()) + (accept ? -0.25D : 0.25D);
/* 177 */     v = CLAMP.d(v, -1.0D, 1.0D);
/*     */     
/* 179 */     this.vassalTribute.value.setD(f.king(), v);
/*     */   }
/*     */   
/*     */   public void poison(FactionNPC f, double amount) {
/* 183 */     amount /= -this.poison.to();
/* 184 */     this.poison.value.incD(f.king(), amount);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsOther.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */