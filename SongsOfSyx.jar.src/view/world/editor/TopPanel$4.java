/*     */ package view.world.editor;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.text.DicTime;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   INT.IntImp tt;
/*     */   INT.IntImp th;
/*     */   GuiSection s;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/* 114 */     super($anonymous0);
/*     */     
/* 116 */     this.tt = new INT.IntImp(0, 1000)
/*     */       {
/*     */         public void set(int t)
/*     */         {
/* 120 */           super.set(t);
/* 121 */           TIME.set((get() * TIME.secondsPerDay()));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 126 */     this.th = new INT.IntImp(0, TIME.hoursPerDay())
/*     */       {
/*     */         public void set(int t)
/*     */         {
/* 130 */           super.set(t);
/* 131 */           TIME.set((TopPanel.null.this.tt.get() * TIME.secondsPerDay()) + getD() * TIME.secondsPerDay());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 136 */     this.s = new GuiSection();
/*     */ 
/*     */     
/* 139 */     this.s.add((RENDEROBJ)new GSliderInt((INT.INTE)this.tt, 100, true)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 143 */             GBox b = (GBox)text;
/* 144 */             GText t = b.text();
/* 145 */             DicTime.setDate((Str)t, (int)TIME.currentSecond());
/* 146 */             b.add((SPRITE)t);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 151 */     this.s.addDownC(4, (RENDEROBJ)new GSliderInt((INT.INTE)this.th, 100, true)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 155 */             GBox b = (GBox)text;
/* 156 */             GText t = b.text();
/* 157 */             DicTime.setDate((Str)t, (int)TIME.currentSecond());
/* 158 */             b.add((SPRITE)t);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 167 */     (VIEW.inters()).popup.show((RENDEROBJ)this.s, (CLICKABLE)this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\editor\TopPanel$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */