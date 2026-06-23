/*    */ package settlement.room.law.stockade;
/*    */ 
/*    */ import init.resources.ResG;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 73 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 77 */     selectedSet(((StockInstance)g.get()).fetch.has(e.resource));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 82 */     ((StockInstance)g.get()).fetch.toggle(e.resource);
/* 83 */     ((StockInstance)g.get()).jobs.resNotFound.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 88 */     GBox b = (GBox)text;
/* 89 */     b.title(e.resource.names);
/* 90 */     b.textLL(Dic.¤¤Consumed).add((SPRITE)GFORMAT.i(b.text(), -((IndustryResource)((ROOM_STOCKADE)Gui.access$2(Gui.this)).indu.ins().get(e.index())).year.get(g.get())));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */