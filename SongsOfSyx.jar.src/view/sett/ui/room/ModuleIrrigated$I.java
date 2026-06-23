/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.water.RoomIrrigated;
/*    */ import settlement.tilemap.ground.Ground;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
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
/*    */ class I
/*    */   extends UIRoomModule
/*    */ {
/*    */   private final RoomIrrigated.ROOM_IRRIGATED p;
/*    */   
/*    */   I(RoomIrrigated.ROOM_IRRIGATED b) {
/* 46 */     this.p = b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 53 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 57 */             GFORMAT.perc(text, CLAMP.d(ModuleIrrigated.I.this.p.irrigation().prospectFlat((AREA)get.get()), 0.0D, 1.0D));
/*    */           }
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GBox b) {
/* 62 */             b.title(Ground.¤¤moisture);
/* 63 */             GText t = b.text();
/*    */             
/* 65 */             RoomInstance i = (RoomInstance)get.get();
/*    */             
/* 67 */             double target = ModuleIrrigated.I.this.p.irrigation().needed((AREA)i) / i.area();
/* 68 */             double current = RoomIrrigated.rawValue((AREA)i);
/* 69 */             double value = ModuleIrrigated.I.this.p.irrigation().prospectFlat((AREA)i);
/*    */             
/* 71 */             t.add((ModuleIrrigated.I.access$0(ModuleIrrigated.I.this)).¤¤Desc);
/* 72 */             t.insert(0, (int)Math.round(100.0D * target));
/* 73 */             t.insert(1, (int)Math.round(100.0D * current));
/* 74 */             t.insert(2, (int)Math.round(100.0D * value));
/* 75 */             t.insert(3, (int)Math.round(100.0D * ModuleIrrigated.I.this.p.irrigation().current(i)));
/* 76 */             b.add((SPRITE)t);
/* 77 */             (SETT.OVERLAY()).MOISTURE.add();
/*    */           }
/* 82 */         }).hh((SETT.ENV()).map.WATER_SWEET.icon));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hover(GBox box, Room room, int rx, int ry) {
/* 90 */     box.add((SETT.ENV()).map.WATER_SWEET.icon);
/* 91 */     box.textL(Ground.¤¤moisture);
/* 92 */     box.tab(6);
/* 93 */     if (room instanceof RoomInstance) {
/* 94 */       box.add((SPRITE)GFORMAT.perc(box.text(), CLAMP.d(this.p.irrigation().prospectFlat((AREA)room), 0.0D, 1.0D)));
/*    */     }
/* 96 */     box.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleIrrigated$I.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */