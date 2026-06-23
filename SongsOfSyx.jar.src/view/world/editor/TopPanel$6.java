/*     */ package view.world.editor;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.SaveFile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import view.world.generator.WorldViewGenerator;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 202 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 207 */     WORLD.WorldError e = new WORLD.WorldError();
/*     */     
/* 209 */     (WORLD.GEN()).playerX = -1;
/* 210 */     (WORLD.GEN()).hasGeneratedTerrain = false;
/*     */     
/* 212 */     for (int ri = 0; ri < WORLD.RESOURCES().size(); ri++) {
/* 213 */       WORLD.WorldResource r = (WORLD.WorldResource)WORLD.RESOURCES().get(ri);
/* 214 */       WorldViewGenerator.loadPrint.exe();
/* 215 */       r.saver().validateInit(e);
/*     */       
/* 217 */       if (e.problem != null) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 222 */       if (r == WORLD.TERRAIN()) {
/* 223 */         (WORLD.GEN()).hasGeneratedTerrain = true;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 229 */     if (e.problem != null) {
/* 230 */       if ((WORLD.GEN()).hasGeneratedTerrain) {
/* 231 */         STRING_RECIEVER ss = new STRING_RECIEVER()
/*     */           {
/*     */             public void acceptString(CharSequence string)
/*     */             {
/* 235 */               if (string != null) {
/* 236 */                 string = SaveFile.stamp(string);
/* 237 */                 (WORLD.GEN()).isEditing = false;
/* 238 */                 GAME.saver().save(String.valueOf(string));
/* 239 */                 (WORLD.GEN()).isEditing = true;
/* 240 */                 (VIEW.inters()).yesNo.activate("The world terrain was saved. The other layers were invalid, so could not be saved.", ACTION.NOP, null, true);
/*     */               } 
/*     */             }
/*     */           };
/*     */         
/* 245 */         (VIEW.inters()).input.requestInput(ss, "name save");
/*     */       } else {
/* 247 */         (VIEW.inters()).yesNo.activate("can't save: " + String.valueOf(e.problem), ACTION.NOP, null, true);
/* 248 */         (VIEW.world()).editor.window.centererTile.set((COORDINATE)e.coo);
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 255 */       (WORLD.GEN()).playerX = (WORLD.REGIONS()).player.cx();
/* 256 */       (WORLD.GEN()).playerY = (WORLD.REGIONS()).player.cy();
/* 257 */       STRING_RECIEVER ss = new STRING_RECIEVER()
/*     */         {
/*     */           public void acceptString(CharSequence string)
/*     */           {
/* 261 */             if (string != null) {
/* 262 */               string = SaveFile.stamp(string);
/* 263 */               (WORLD.GEN()).isEditing = false;
/* 264 */               GAME.saver().save(String.valueOf(string));
/* 265 */               (WORLD.GEN()).isEditing = true;
/* 266 */               (VIEW.inters()).yesNo.activate("Save was a stunning success.", ACTION.NOP, null, true);
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 271 */       (VIEW.inters()).input.requestInput(ss, "name save");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\editor\TopPanel$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */