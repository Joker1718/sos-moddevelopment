/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.superb.SuperBoostable;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.boosting.superb.SuperSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class RTrust {
/*  25 */   private static CharSequence ¤¤rName = "Rivalry";
/*  26 */   private static CharSequence ¤¤vassal = "Vassal";
/*  27 */   private static CharSequence ¤¤hName = "Honor";
/*  28 */   private static CharSequence ¤¤rFactors = "Trust is gained by maintaining high opinion and treaties, and eroded by rivalry, which is your wealth compared to theirs. Trust below 100% might result in a spontaneous attack, or joining your enemies, if the faction feels like they're on the winning side.";
/*     */   
/*     */   static {
/*  31 */     D.ts(RTrust.class);
/*     */   }
/*     */   
/*  34 */   public final Boostable bo = (BOOSTABLES.CIVICS()).TRUST;
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
/*     */   RTrust(FACTIONS factions) {}
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
/*     */   public static SuperBoostable<Royalty> BOOST() {
/* 124 */     return (GAME.BOOSTS()).TRUST;
/*     */   }
/*     */   
/*     */   private static abstract class BB
/*     */     extends SuperSpec<Royalty> {
/*     */     public BB(CharSequence name, SPRITE icon, double from, double to, boolean isMul) {
/* 130 */       super(RTrust.BOOST(), new BSourceInfo(name, icon), "", from, to, isMul);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double secondsRemaining(Royalty bo) {
/* 137 */       return 0.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double increase(Royalty bo) {
/* 143 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     protected double pget(Royalty o) {
/* 148 */       if (o == null) {
/* 149 */         return 0.0D;
/*     */       }
/* 151 */       return vGet(o.court.faction);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract double vGet(FactionNPC param1FactionNPC);
/*     */   }
/*     */   
/*     */   public double get(FactionNPC f) {
/* 159 */     return BOOST().get((SuperBoostableObj)f.king());
/*     */   }
/*     */   
/*     */   public double get(GETTER<FactionNPC> f) {
/* 163 */     return BOOST().get((SuperBoostableObj)((FactionNPC)f.get()).king());
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, FactionNPC f) {
/* 167 */     GBox b = (GBox)box;
/* 168 */     b.title(this.bo.name);
/* 169 */     b.text(this.bo.desc);
/* 170 */     b.NL(4);
/* 171 */     b.text(¤¤rFactors);
/* 172 */     b.NL(4);
/* 173 */     b.textLL(ROPINION.¤¤wEmmi);
/* 174 */     b.tab(6);
/* 175 */     b.add((SPRITE)GFORMAT.perc(b.text(), ROPINION.EMMI().trustTarget(f.king(), 1.0D)));
/* 176 */     b.sep();
/* 177 */     BOOST().hoverDetailed((GUI_BOX)b, (SuperBoostableObj)f.court().king().roy());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\RTrust.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */