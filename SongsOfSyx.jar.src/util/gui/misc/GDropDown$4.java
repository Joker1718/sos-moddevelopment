/*     */ package util.gui.misc;
/*     */ 
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.GETTER;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 166 */     CLICKABLE.ClickWrap wr = new CLICKABLE.ClickWrap(width, height)
/*     */       {
/*     */         protected CLICKABLE pget() {
/* 169 */           if (ier.get() == null)
/* 170 */             return (CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).dummy; 
/* 171 */           int i = ((Integer)ier.get()).intValue();
/* 172 */           if (i >= (GDropDown.null.access$0(GDropDown.null.this)).es.size())
/* 173 */             return (CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).dummy; 
/* 174 */           return (CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).es.get(i);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean click() {
/* 179 */           int i = ((Integer)ier.get()).intValue();
/* 180 */           GDropDown.null.access$0(GDropDown.null.this).setSelected((CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).es.get(i));
/* 181 */           if (super.click()) {
/*     */             
/* 183 */             if (i < (GDropDown.null.access$0(GDropDown.null.this)).es.size())
/*     */             {
/* 185 */               (GDropDown.null.access$0(GDropDown.null.this)).inter.hide();
/*     */             }
/* 187 */             return true;
/*     */           } 
/* 189 */           return false;
/*     */         }
/*     */       };
/* 192 */     return (RENDEROBJ)wr;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GDropDown$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */