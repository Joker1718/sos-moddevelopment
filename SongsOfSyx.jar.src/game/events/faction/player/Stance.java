/*     */ package game.events.faction.player;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealBool;
/*     */ import game.faction.diplomacy.deal.DealDrawfter;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.race.KingMessages;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.ui.diplomacy.UIDipMess;
/*     */ import view.ui.diplomacy.UIDipMessDeal;
/*     */ import view.ui.message.MessageText;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Stance
/*     */ {
/*  28 */   private static CharSequence ¤¤Welcome = "Welcome";
/*  29 */   private static CharSequence ¤¤AgreementCancelled = "¤Agreement Cancelled.";
/*  30 */   private static CharSequence ¤¤AgreementCancelledD = "¤This faction has gone from the stance of {0} to the stance of {1}.";
/*     */   
/*  32 */   private static CharSequence ¤¤Warning = "¤Relations Worsen.";
/*  33 */   private static CharSequence ¤¤WarningD = "¤This faction is currently your {0}. If their opinion is not raised in time, it is possible they'll cancel this agreement.";
/*     */   
/*  35 */   private static CharSequence ¤¤TradeCancelled = "¤Agreements Cancelled.";
/*  36 */   private static CharSequence ¤¤TradeCancelledD = "¤Since the faction of {0} is no longer reachable to us, all agreements have been annulled.";
/*     */   
/*  38 */   private static CharSequence ¤¤title = "Proposal: {0}";
/*     */   
/*     */   static {
/*  41 */     D.ts(Stance.class);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean process(FactionNPC fa, Induvidual king, EventDiplomacy.EData data) {
/*  46 */     if (DIP.secondSinceStance(fa) < TIME.secondsPerDay()) {
/*  47 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  52 */     if (!RD.DIST().reachable((Faction)fa)) {
/*  53 */       return false;
/*     */     }
/*  55 */     KingMessages m = king.race().kingMessage();
/*     */     
/*  57 */     if ((DIP.get(fa)).trades && !RD.DIST().reachable((Faction)fa)) {
/*  58 */       DIP.NEUTRAL().set((Faction)fa, (Faction)FACTIONS.player());
/*  59 */       (new MessageText(¤¤TradeCancelled, (CharSequence)Str.TMP.clear().add(¤¤TradeCancelledD).insert(0, (CharSequence)fa.name))).send();
/*  60 */       return true;
/*     */     } 
/*     */     
/*  63 */     double opinion = ROPINION.get(fa);
/*     */     
/*  65 */     if (DIP.TRADE().is(fa)) {
/*  66 */       if (opinion < (DIP.TRADE()).opinionNeeded * 0.75D) {
/*  67 */         return messDown(fa, DIP.NEUTRAL(), DIP.TRADE(), data);
/*     */       }
/*  69 */       return false;
/*     */     } 
/*     */     
/*  72 */     if (DIP.PACT().is(fa)) {
/*  73 */       if (opinion < (DIP.PACT()).opinionNeeded * 0.75D) {
/*  74 */         return messDown(fa, DIP.TRADE(), DIP.PACT(), data);
/*     */       }
/*  76 */       return false;
/*     */     } 
/*     */     
/*  79 */     if (DIP.ALLY().is(fa) && 
/*  80 */       opinion < (DIP.ALLY()).opinionNeeded * 0.75D) {
/*  81 */       return messDown(fa, DIP.PACT(), DIP.ALLY(), data);
/*     */     }
/*     */ 
/*     */     
/*  85 */     if (!(SETT.ROOMS()).IMPORT.reqs.passes(FACTIONS.player())) {
/*  86 */       return false;
/*     */     }
/*  88 */     if (!data.welcomed && DIP.NEUTRAL().is(fa)) {
/*     */       
/*  90 */       if (!RND.oneIn(4)) {
/*  91 */         return false;
/*     */       }
/*  93 */       if (ROPINION.get(fa) > 0.4D) {
/*     */         
/*  95 */         Deal d = DIP.TMP();
/*  96 */         d.setFactionAndClear(fa);
/*  97 */         double max = giftWorth(fa);
/*  98 */         if (max > 0.0D) {
/*     */           
/* 100 */           DealDrawfter.draft(d, max, false, false);
/* 101 */           if (d.hasDeal()) {
/*     */             
/* 103 */             data.welcomed = true;
/* 104 */             (new UIDipMessDeal(¤¤Welcome, m.GREETING_GOOD.get(fa), d, 0.0D, -0.1D)).send();
/* 105 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 111 */       (new UIDipMess(¤¤Welcome, m.GREETING_BAD.get(fa), "", fa)).send();
/* 112 */       data.welcomed = true;
/* 113 */       return false;
/*     */     } 
/*     */     
/* 116 */     boolean chance = RND.oneIn(32 * (1 + RD.DIST().neighs().size()));
/*     */ 
/*     */     
/* 119 */     if (!chance) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (DIP.NEUTRAL().is(fa) && 
/* 123 */       opinion > (DIP.TRADE()).opinionNeeded + 0.5D) {
/* 124 */       messUp(fa, (DIP.TMP()).bools.TRADE, DIP.TRADE());
/* 125 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 129 */     if (DIP.TRADE().is(fa) && 
/* 130 */       opinion > (DIP.PACT()).opinionNeeded + 0.5D) {
/* 131 */       messUp(fa, (DIP.TMP()).bools.PACT, DIP.TRADE());
/* 132 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 136 */     if (DIP.PACT().is(fa) && 
/* 137 */       opinion > (DIP.ALLY()).opinionNeeded + 0.5D) {
/* 138 */       messUp(fa, (DIP.TMP()).bools.ALLY, DIP.TRADE());
/* 139 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean messDown(FactionNPC fa, DipStance downTo, DipStance current, EventDiplomacy.EData data) {
/* 150 */     if (fa.request.has())
/* 151 */       return false; 
/* 152 */     KingMessages m = (fa.court().king().roy()).induvidual.race().kingMessage();
/* 153 */     if (data.stanceMess) {
/*     */       
/* 155 */       Str.TMP.clear().add(¤¤AgreementCancelledD);
/* 156 */       Str.TMP.insert(0, (DIP.get(fa)).name);
/* 157 */       Str.TMP.insert(1, downTo.name);
/* 158 */       (new UIDipMess(¤¤AgreementCancelled, m.STANCE_DOWN.get(fa), (CharSequence)Str.TMP, fa)).send();
/* 159 */       downTo.set(fa);
/* 160 */       data.stanceMess = false;
/*     */     } else {
/* 162 */       Str.TMP.clear().add(¤¤WarningD);
/* 163 */       Str.TMP.insert(0, (DIP.get(fa)).name);
/*     */       
/* 165 */       double more = ROPINION.GIFTS().getGenerosityNeededForOpinion(fa, current.opinionNeeded + 0.5D);
/*     */       
/* 167 */       Deal d = DIP.TMP();
/* 168 */       d.setFactionAndClear(fa);
/* 169 */       double am = d.getWorthOfOpinion(more) * 0.9D;
/* 170 */       DealDrawfter.draft(d, -am, false, false);
/* 171 */       if (am > d.valueCredits()) {
/* 172 */         d.player.credits.i = (int)(d.player.credits.i + am - d.valueCredits());
/*     */       }
/* 174 */       data.stanceMess = true;
/*     */       
/* 176 */       (new UIDipMessDeal(¤¤Warning, m.STANCE_WARNING.get(fa), d, more, 0.0D)).send();
/*     */     } 
/* 178 */     return true;
/*     */   }
/*     */   
/*     */   private static void messUp(FactionNPC fa, DealBool bool, DipStance stance) {
/* 182 */     if (fa.request.has())
/*     */       return; 
/* 184 */     Deal d = DIP.TMP();
/* 185 */     d.setFactionAndClear(fa);
/* 186 */     bool.set(true);
/* 187 */     double v = -d.valueCredits();
/* 188 */     double b = v * 0.5D + 0.5D + RND.rFloat();
/* 189 */     DealDrawfter.draft(d, b, false, true);
/* 190 */     if (v < d.player.offerableWorth()) {
/* 191 */       KingMessages m = (fa.court().king().roy()).induvidual.race().kingMessage();
/* 192 */       (new UIDipMessDeal((CharSequence)Str.TMP.clear().add(¤¤title).insert(0, stance.name), m.STANCE_UP.get(fa), d, 0.0D, -0.1D)).send();
/*     */     } 
/*     */   }
/*     */   
/*     */   private double giftWorth(FactionNPC fa) {
/* 197 */     Deal d = DIP.TMP();
/* 198 */     double min = 2000.0D;
/* 199 */     double max = 60000.0D;
/* 200 */     max = Math.min(max, d.npc.offerableWorth() * 0.025D);
/* 201 */     if (max > min)
/*     */     {
/* 203 */       return min + (BOOSTABLES.NOBLE()).PRIDE.get((BOOSTABLE_O)(fa.king()).induvidual) * (max - min);
/*     */     }
/*     */     
/* 206 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\Stance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */