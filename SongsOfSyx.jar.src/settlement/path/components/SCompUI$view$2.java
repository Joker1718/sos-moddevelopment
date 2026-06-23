/*     */ package settlement.path.components;
/*     */ 
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 130 */     text.lablify();
/* 131 */     text.add(SCompUI.view.this.comp.index());
/* 132 */     text.s();
/*     */     
/* 134 */     if (SCompUI.view.this.comp.hasEdge()) {
/* 135 */       text.s();
/* 136 */       text.add('b');
/*     */     } 
/* 138 */     if (SCompUI.view.this.comp.hasEntry()) {
/* 139 */       text.s();
/* 140 */       text.add('e');
/*     */     } 
/*     */     
/* 143 */     text.s().s().add('s');
/* 144 */     if (SCompUI.view.this.comp.superComp() != null) {
/* 145 */       text.s().add(SCompUI.view.this.comp.superComp().index());
/*     */     }
/* 147 */     text.s().s().s();
/* 148 */     text.add('(').add(VIEW.s().getWindow().tile().x()).s().add(VIEW.s().getWindow().tile().y()).add(')');
/* 149 */     text.s().add(SCompUI.view.this.comp.retired());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompUI$view$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */