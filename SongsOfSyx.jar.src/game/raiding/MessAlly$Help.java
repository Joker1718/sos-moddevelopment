/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GButt;
/*     */ import view.ui.diplomacy.UIDipMess;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Help
/*     */   extends UIDipMess
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final MessDemand.Demand demand;
/*     */   private boolean requested = false;
/*     */   
/*     */   private Help(CharSequence message, FactionNPC f, MessDemand.Demand demand) {
/*  90 */     super(MessAlly.¤¤title, message, MessAlly.¤¤desc, f);
/*  91 */     this.demand = demand;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/*  96 */     super.make(section);
/*  97 */     section.addRelBody(8, DIR.S, this.demand.section(true));
/*  98 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GButt.ButtPanel(MessAlly.¤¤requestHelp)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/* 102 */             selectedSet(MessAlly.Help.this.requested);
/* 103 */             activeSet(MessAlly.Help.this.demand.canRespond());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 108 */             if (!MessAlly.Help.this.requested && MessAlly.Help.this.demand.canRespond()) {
/* 109 */               MessAlly.Help.this.requested = true;
/* 110 */               (GAME.raiders()).current.setAllyFight();
/*     */             }
/*     */           
/*     */           }
/* 114 */         }).hoverInfoSet(MessAlly.¤¤requestHelpD));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessAlly$Help.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */