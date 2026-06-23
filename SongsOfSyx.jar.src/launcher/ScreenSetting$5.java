/*     */ package launcher;
/*     */ 
/*     */ import snake2d.SoundDevices;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GUI.Button
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 160 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 164 */     GuiSection mFullScreens = new GuiSection();
/* 165 */     final GUI.ScrollBox content = new GUI.ScrollBox(348);
/*     */     
/* 167 */     CLICKABLE up = (new GUI.BSprite(l.res.arrowUpDown[0])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 170 */             content.scrollUp();
/*     */           }
/*     */         });
/* 173 */     mFullScreens.add((RENDEROBJ)up);
/*     */ 
/*     */     
/* 176 */     CLICKABLE down = (new GUI.BSprite(l.res.arrowUpDown[1])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 179 */             content.scrollDown();
/*     */           }
/*     */         });
/* 182 */     down.body().moveY2(328.0D);
/*     */     
/* 184 */     mFullScreens.add((RENDEROBJ)down);
/* 185 */     content.addNavButts(up, down);
/* 186 */     content.body().moveX1Y1(30.0D, 0.0D);
/*     */     
/* 188 */     content.add((HOVERABLE)(new GUI.BText(l.res, none)).clickActionSet(new ACTION()
/*     */           {
/*     */             public void exe() {
/* 191 */               l.s.audiodevice.set((String)null);
/* 192 */               (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */             }
/*     */           }));
/*     */     
/* 196 */     content.add((HOVERABLE)(new GUI.BText(l.res, def)).clickActionSet(new ACTION()
/*     */           {
/*     */             public void exe() {
/* 199 */               l.s.audiodevice.set("");
/* 200 */               (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */             }
/*     */           }));
/*     */     
/* 204 */     for (String s : SoundDevices.get()) {
/* 205 */       content.add((HOVERABLE)(new GUI.BText(l.res, s)).clickActionSet(new ACTION()
/*     */             {
/*     */               public void exe() {
/* 208 */                 l.s.audiodevice.set(s);
/* 209 */                 (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */               }
/*     */             }));
/*     */     } 
/*     */     
/* 214 */     mFullScreens.add((RENDEROBJ)content);
/*     */     
/* 216 */     GUI.BText bText = new GUI.BText(l.res, D.g("Back"))
/*     */       {
/*     */         protected void clickA() {
/* 219 */           (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 224 */     bText.body().moveX1(80.0D);
/* 225 */     bText.body().moveY1((mFullScreens.getLastY2() + 10));
/* 226 */     mFullScreens.add((RENDEROBJ)bText);
/* 227 */     mFullScreens.body().centerX(0.0D, 896.0D);
/* 228 */     mFullScreens.body().centerY(0.0D, 448.0D);
/*     */     
/* 230 */     ScreenSetting.this.message = mFullScreens;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 235 */     if (super.hover(mCoo) && this.hoverInfo != null) {
/* 236 */       ScreenSetting.this.hoverInfo.add(this.hoverInfo);
/* 237 */       return true;
/*     */     } 
/* 239 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenSetting$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */