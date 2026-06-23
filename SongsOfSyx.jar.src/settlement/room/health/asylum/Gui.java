/*    */ package settlement.room.health.asylum;
/*    */ import init.sprite.SPRITES;
/*    */ import init.type.HTYPES;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GGrid;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ class Gui extends UIRoomModule.UIRoomModuleImp<AsylumInstance, ROOM_ASYLUM> {
/* 19 */   private static CharSequence ¤¤Treatment = "¤Treatment";
/* 20 */   private static CharSequence ¤¤TreatmentD = "¤Treatment factor is determined my the number of employed wards and degrade of the room. Keep rooms fully employed for the best recover rates.";
/*    */   
/*    */   static {
/* 23 */     D.ts(Gui.class);
/*    */   }
/*    */   
/*    */   Gui(ROOM_ASYLUM s) {
/* 27 */     super(s);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<AsylumInstance> g, int x1, int y1) {
/* 34 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 38 */             GFORMAT.iofkNoColor(text, ((AsylumInstance)g.get()).prisoners(), ((AsylumInstance)g.get()).prisonersMax());
/*    */           }
/* 40 */         }).hv((HTYPES.DERANGED()).names));
/*    */     
/* 42 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 46 */             GFORMAT.perc(text, ((ROOM_ASYLUM)Gui.this.blueprint).treatmentFactor((AsylumInstance)g.get()));
/*    */           }
/* 48 */         }).hv(¤¤Treatment).hoverInfoSet(¤¤TreatmentD));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void appendMain(GGrid grid, GGrid text, GuiSection sExtra) {
/* 55 */     RENDEROBJ r = null;
/*    */     
/* 57 */     HOVERABLE hOVERABLE = (new GStat()
/*    */       {
/*    */         public void update(GText text)
/*    */         {
/* 61 */           GFORMAT.iofk(text, ((ROOM_ASYLUM)Gui.this.blueprint).prisoners(), ((ROOM_ASYLUM)Gui.this.blueprint).prisonersMax());
/*    */         }
/* 63 */       }).hh((SPRITE)(SPRITES.icons()).s.crazy).hoverInfoSet((HTYPES.DERANGED()).desc);
/*    */     
/* 65 */     text.add((RENDEROBJ)hOVERABLE);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hover(GBox box, AsylumInstance i) {
/* 70 */     box.NL();
/* 71 */     box.text((HTYPES.DERANGED()).names);
/* 72 */     box.add((SPRITE)GFORMAT.iofk(box.text(), i.prisoners(), i.prisonersMax()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */