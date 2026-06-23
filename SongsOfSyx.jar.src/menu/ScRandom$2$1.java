/*     */ package menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import script.ScriptLoad;
/*     */ import snake2d.CORE_STATE;
/*     */ import view.main.VIEW;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements CORE_STATE.Constructor
/*     */ {
/*     */   public CORE_STATE getState() {
/*  87 */     String[] sc = new String[(ScRandom.null.access$0(ScRandom.null.this)).scripts.all().size()];
/*  88 */     int si = 0;
/*  89 */     for (ScriptLoad l : (ScRandom.null.access$0(ScRandom.null.this)).scripts.all()) {
/*  90 */       sc[si++] = l.key;
/*     */     }
/*  92 */     VIEW vIEW = GAME.create(sc);
/*     */     
/*  94 */     if ((ScRandom.null.access$0(ScRandom.null.this)).selectedMode == null) {
/*  95 */       menu.sandboxSettings.apply();
/*     */     } else {
/*  97 */       (FACTIONS.player()).bonusesCustom.setMode((ScRandom.null.access$0(ScRandom.null.this)).selectedMode);
/*     */     } 
/*     */ 
/*     */     
/* 101 */     return (CORE_STATE)vIEW;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScRandom$2$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */