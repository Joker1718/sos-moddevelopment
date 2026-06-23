/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ import util.gui.table.GTableBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GTableBuilder.GRowBuilder
/*    */ {
/*    */   public RENDEROBJ build(final GETTER<Integer> ier) {
/* 59 */     return (RENDEROBJ)new RENDEROBJ.RenderImp(512, SInfoDesc.this.font.height())
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, float ds)
/*    */         {
/* 63 */           int s = (SInfoDesc.null.access$0(SInfoDesc.null.this)).starts[((Integer)ier.get()).intValue()];
/* 64 */           int e = (SInfoDesc.null.access$0(SInfoDesc.null.this)).ends[((Integer)ier.get()).intValue()];
/* 65 */           (SInfoDesc.null.access$0(SInfoDesc.null.this)).cols[((Integer)ier.get()).intValue()].bind();
/* 66 */           (SInfoDesc.null.access$0(SInfoDesc.null.this)).font.render(r, (CharSequence)(SInfoDesc.null.access$0(SInfoDesc.null.this)).str, body().x1(), body().y1(), s, e, 1.0D);
/* 67 */           COLOR.unbind();
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\SInfoDesc$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */