/*     */ package view.menu;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.save.SaveFile;
/*     */ import snake2d.util.sets.KeyMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends MenuScreen.ScreenButton
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 101 */     super($anonymous0);
/*     */   }
/*     */   protected void clickA() {
/* 104 */     String name = String.valueOf((FACTIONS.player()).name) + "-";
/* 105 */     KeyMap<String> m = new KeyMap(); byte b; int j; SaveFile[] arrayOfSaveFile;
/* 106 */     for (j = (arrayOfSaveFile = IMenuSave.this.saves).length, b = 0; b < j; ) { SaveFile f = arrayOfSaveFile[b];
/* 107 */       if (f.name.startsWith(name)) {
/* 108 */         String n = f.name.substring(name.length(), f.name.length());
/* 109 */         m.putReplace(n, n);
/*     */       } 
/*     */       b++; }
/*     */     
/* 113 */     String ph = "";
/*     */     
/* 115 */     for (int i = 0; i < 512; i++) {
/* 116 */       String k = "" + i;
/* 117 */       if (!m.containsKey(k)) {
/* 118 */         ph = name + name;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 124 */     (VIEW.inters()).input.requestInput(IMenuSave.this, IMenuSave.¤¤¤nameYour, ph);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuSave$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */