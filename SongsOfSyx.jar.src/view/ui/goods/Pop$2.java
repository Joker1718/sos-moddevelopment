/*    */ package view.ui.goods;
/*    */ 
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.gui.table.GTableBuilder;
/*    */ import util.info.GFORMAT;
/*    */ import view.main.VIEW;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
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
/* 37 */     GuiSection s = new GuiSection()
/*    */       {
/*    */         protected void clickA() {
/* 40 */           Region r = (Region)(Pop.null.access$0(Pop.null.this)).regs.get(((Integer)ier.get()).intValue());
/* 41 */           if (r != null) {
/* 42 */             (VIEW.UI()).manager.close();
/* 43 */             VIEW.world().activate();
/* 44 */             (VIEW.world()).UI.regions.open(r);
/*    */           } 
/*    */           
/* 47 */           super.clickA();
/*    */         }
/*    */       };
/* 50 */     s.add((RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 54 */             Region r = (Region)(Pop.null.access$0(Pop.null.this)).regs.get(((Integer)ier.get()).intValue());
/* 55 */             if (r != null) {
/* 56 */               text.add((CharSequence)r.info.name());
/*    */             }
/*    */           }
/* 59 */         }).r());
/*    */     
/* 61 */     s.addRightC(180, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 65 */             Region r = (Region)(Pop.null.access$0(Pop.null.this)).regs.get(((Integer)ier.get()).intValue());
/* 66 */             if (r != null) {
/* 67 */               GFORMAT.iIncr(text, RD.OUTPUT().get((Pop.null.access$0(Pop.null.this)).res.tr()).getDelivery(r));
/*    */             }
/*    */           }
/* 70 */         }).r());
/* 71 */     s.pad(0, 6);
/*    */     
/* 73 */     return (RENDEROBJ)s;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\Pop$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */