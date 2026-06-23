/*     */ package game.faction.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import view.ui.message.MessageSection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MVassal
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final int credits;
/*     */   private final int fi;
/*     */   
/*     */   public MVassal(Faction ff) {
/*  92 */     super(UpVassal.¤¤tribute);
/*  93 */     this.fi = ff.index();
/*     */     
/*  95 */     int credits = (int)FACTIONS.WORTH().faction();
/*  96 */     credits = (int)(credits * 0.1D);
/*  97 */     credits = Math.max(credits, (FACTIONS.player().credits()).worth.get(0) - (FACTIONS.player().credits()).worth.get(1));
/*  98 */     if (credits < 0) {
/*  99 */       credits = 100;
/*     */     }
/* 101 */     int am = (int)FACTIONS.player().credits().getD();
/* 102 */     am = CLAMP.i(am, 0, credits);
/* 103 */     if (am < credits) {
/* 104 */       am += (credits - am) / 4;
/*     */     }
/*     */     
/* 107 */     this.credits = am;
/*     */     
/* 109 */     FACTIONS.player().credits().inc(-this.credits, FCredits.CTYPE.TRIBUTE);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 114 */     paragraph(UpVassal.¤¤vassal);
/*     */     
/* 116 */     section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 120 */             GFORMAT.i(text, -UpVassal.MVassal.this.credits);
/*     */           }
/* 122 */         }).hh((SPRITE)(UI.icons()).m.coins));
/* 123 */     Faction f = FACTIONS.getByIndex(this.fi);
/* 124 */     if (f != null)
/* 125 */       section.addRelBody(16, DIR.N, (f.banner()).HUGE); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\UpVassal$MVassal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */