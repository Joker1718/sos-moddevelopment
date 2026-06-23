/*    */ package view.ui.tech;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.UI;
/*    */ import init.tech.TechTree;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GText;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ class Edge
/*    */   extends RENDEROBJ.RenderImp
/*    */ {
/*    */   SPRITE sprite;
/* 19 */   int m = 0;
/* 20 */   int a = 0;
/* 21 */   int hm = 0;
/*    */   public int hoverI;
/*    */   
/*    */   Edge(int w, int h) {
/* 25 */     this.body.setDim(w, h);
/*    */   }
/*    */   
/*    */   Edge(TechTree tree, int mw, int wi) {
/* 29 */     super(wi, 32);
/* 30 */     final GText tt = (new GText((UI.FONT()).H2, tree.name)).lablify();
/* 31 */     final int x1 = ((mw - 1) * 112 + 80) / 2 - tt.width() / 2;
/* 32 */     final int w = (mw - 1) * 112 + 80;
/* 33 */     final SPRITE bo = UI.decor().borderTop(w);
/*    */     
/* 35 */     this.sprite = (SPRITE)new SPRITE.Imp()
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */         {
/* 39 */           tt.render(r, X1 - x1 - tt.width(), Y2 - tt.height() - bo.height() - 4 - 8);
/* 40 */           bo.render(r, X1 - w, X1, Y2 - bo.height() - 8, Y2 - 8);
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 49 */     render(r, COLOR.WHITE10, 3, this.m);
/* 50 */     render(r, COLOR.WHITE15, 2, this.m);
/*    */     
/* 52 */     if (this.hoverI == VIEW.renI) {
/* 53 */       render(r, COLOR.WHITE65, 3, this.hm);
/* 54 */       render(r, COLOR.WHITE85, 2, this.hm);
/*    */     } 
/*    */ 
/*    */     
/* 58 */     for (DIR d : DIR.ORTHO) {
/* 59 */       if ((d.mask() & this.a) != 0) {
/* 60 */         if (this.hoverI == VIEW.renI && (d.mask() & this.hm) != 0) {
/* 61 */           COLOR.WHITE85.bind();
/*    */         } else {
/* 63 */           COLOR.WHITE50.bind();
/* 64 */         }  int cx = this.body.cX() + d.x() * (this.body.width() - 16 - 12) / 2;
/* 65 */         int cy = this.body.cY() + d.y() * (this.body.height() - 16 - 12) / 2;
/* 66 */         (SPRITES.icons()).s.chevron(d).renderC(r, cx, cy);
/*    */       } 
/*    */     } 
/*    */     
/* 70 */     COLOR.unbind();
/*    */     
/* 72 */     if (this.sprite != null) {
/* 73 */       this.sprite.render(r, (RECTANGLE)this.body);
/*    */     }
/*    */   }
/*    */   
/*    */   private void render(SPRITE_RENDERER r, COLOR c, int mm, int m) {
/* 78 */     if (m != 0) {
/* 79 */       c.render(r, this.body.cX() - mm, this.body.cX() + mm, this.body.cY() - mm, this.body.cY() + mm);
/* 80 */       for (DIR d : DIR.ORTHO) {
/*    */         
/* 82 */         if ((d.mask() & m) != 0) {
/* 83 */           int dd = ((d.mask() & this.a) != 0) ? -1 : 0;
/* 84 */           int x1 = this.body.cX() + d.x() * (this.body.width() + dd) / 2 + d.y() * mm;
/* 85 */           int y1 = this.body.cY() + d.y() * (this.body.height() + dd) / 2 + d.x() * mm;
/* 86 */           int x2 = this.body.cX() - d.y() * mm;
/* 87 */           int y2 = this.body.cY() - d.x() * mm;
/* 88 */           c.render(r, x1, x2, y1, y2);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   void hover(int m) {
/* 95 */     if (this.hoverI != VIEW.renI + 1)
/* 96 */       this.hm = 0; 
/* 97 */     this.hm |= m;
/* 98 */     this.hoverI = VIEW.renI + 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Edge.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */