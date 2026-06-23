/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.water.RoomPumpable;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
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
/*    */ class I
/*    */   extends UIRoomModule
/*    */ {
/*    */   private final RoomPumpable.ROOM_PUMPABLE p;
/*    */   
/*    */   I(RoomPumpable.ROOM_PUMPABLE b) {
/* 49 */     this.p = b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 56 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 60 */             int x = ((RoomInstance)get.get()).mX();
/* 61 */             int y = ((RoomInstance)get.get()).mY();
/* 62 */             GFORMAT.perc(text, ModulePumpable.I.this.p.pumpable(x, y).irrigation(x, y));
/*    */           }
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GBox b) {
/* 67 */             b.title((ModulePumpable.I.access$0(ModulePumpable.I.this)).¤¤Name);
/* 68 */             b.text((ModulePumpable.I.access$0(ModulePumpable.I.this)).¤¤Desc);
/*    */             
/* 70 */             int x = ((RoomInstance)get.get()).mX();
/* 71 */             int y = ((RoomInstance)get.get()).mY();
/* 72 */             double d = ModulePumpable.I.this.p.pumpable(x, y).suckAmount(x, y);
/* 73 */             b.NL();
/* 74 */             b.textLL(Dic.¤¤Current);
/* 75 */             b.tab(6);
/* 76 */             b.add((SPRITE)GFORMAT.iofkInv(b.text(), (long)Math.ceil(d * ModulePumpable.I.this.p.pumpable(x, y).irrigation(x, y) * ((RoomInstance)get.get()).area()), (long)Math.ceil(d * ((RoomInstance)get.get()).area())));
/* 77 */             b.NL();
/* 78 */             b.textLL((ModulePumpable.I.access$0(ModulePumpable.I.this)).¤¤Preasure);
/* 79 */             b.NL();
/* 80 */             b.add((SPRITE)GFORMAT.f(b.text(), d));
/*    */           }
/* 85 */         }).hh((SPRITE)(UI.icons()).s.drop.createColored(COLOR.BLUEISH)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hover(GBox box, Room room, int rx, int ry) {
/* 93 */     box.add(ModulePumpable.this.icon);
/* 94 */     box.textL(ModulePumpable.this.¤¤Name);
/* 95 */     box.tab(6);
/* 96 */     box.add((SPRITE)GFORMAT.perc(box.text(), this.p.pumpable(rx, ry).irrigation(rx, ry)));
/* 97 */     box.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModulePumpable$I.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */