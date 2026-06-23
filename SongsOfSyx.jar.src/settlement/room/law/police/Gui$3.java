/*     */ package settlement.room.law.police;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.GUTIL;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
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
/*     */ class null
/*     */   extends GTableBuilder.GRowBuilder
/*     */ {
/*     */   public RENDEROBJ build(final GETTER<Integer> ier) {
/*  94 */     GButt.BSection r = new GButt.BSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  98 */           if (ier.get() == null)
/*     */             return; 
/* 100 */           Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 101 */           (VIEW.s()).ui.subjects.hoverInfo(h, (GBox)text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 106 */     r.add((SPRITE)new GStat((UI.FONT()).H2)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 110 */             if (ier.get() == null)
/*     */               return; 
/* 112 */             Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 113 */             text.lablify();
/* 114 */             text.add(STATS.APPEARANCE().name(h.indu()));
/*     */           }
/* 116 */         }0, 0);
/*     */     
/* 118 */     r.addDown(2, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 122 */             if (ier.get() == null)
/*     */               return; 
/* 124 */             Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 125 */             text.warnify();
/* 126 */             text.add(Gui.tt[STATS.RAN().get(h.indu(), 5) % Gui.tt.length]);
/*     */           }
/*     */         });
/*     */     
/* 130 */     r.addRelBody(8, DIR.W, (SPRITE)new SPRITE.Imp(40, 64)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 134 */             if (ier.get() == null)
/*     */               return; 
/* 136 */             Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 137 */             STATS.APPEARANCE().portraitRender(r, h.indu(), X1, Y1, 1);
/*     */           }
/*     */         });
/*     */     
/* 141 */     r.body().setWidth(384.0D);
/*     */     
/* 143 */     r.pad(8, 3);
/*     */     
/* 145 */     return (RENDEROBJ)r;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\Gui$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */