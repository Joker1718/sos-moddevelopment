/*    */ package settlement.room.law.execution;
/*    */ 
/*    */ import init.settings.S;
/*    */ import java.util.Arrays;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ class Gui
/*    */   extends UIRoomModule
/*    */ {
/* 19 */   private static CharSequence ¤¤available = "Available Executions";
/* 20 */   private static CharSequence ¤¤spectators = "Spectators";
/*    */   
/*    */   static {
/* 23 */     D.ts(Gui.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private final ROOM_EXECTUTION b;
/*    */   final int[] states;
/*    */   private final Rec body;
/*    */   
/*    */   Gui(ROOM_EXECTUTION s) {
/* 32 */     this.states = Alloc.ii(6);
/* 33 */     this.body = new Rec();
/*    */     this.b = s;
/*    */   }
/*    */   
/*    */   public void hover(GBox box, Room room, int rx, int ry) {
/* 38 */     box.NL();
/*    */     
/* 40 */     this.body.moveX1Y1(room.x1(rx, ry), room.y1(rx, ry));
/* 41 */     this.body.setDim(room.width(rx, ry), room.height(rx, ry));
/*    */     
/* 43 */     int available = 0;
/* 44 */     int total = 0;
/* 45 */     Arrays.fill(this.states, 0);
/* 46 */     int specs = 0;
/* 47 */     int specsTot = 0;
/* 48 */     for (COORDINATE c : this.body) {
/* 49 */       if (room.isSame(rx, ry, c.x(), c.y())) {
/* 50 */         ExecutionStation.Client cl = this.b.stations.client(c.x(), c.y());
/* 51 */         if (cl != null) {
/* 52 */           total++;
/* 53 */           if (!cl.clientReserved())
/* 54 */             available++; 
/* 55 */           if (this.b.stations.service(c.x(), c.y()) != null) {
/* 56 */             specsTot += 8;
/* 57 */             specs += this.b.stations.sevices(c.x(), c.y());
/*    */           } 
/* 59 */           this.states[this.b.stations.state(c.x(), c.y())] = this.states[this.b.stations.state(c.x(), c.y())] + 1;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 64 */     box.textLL(¤¤spectators);
/* 65 */     box.tab(7);
/* 66 */     box.add((SPRITE)GFORMAT.iofk(box.text(), specs, specsTot));
/* 67 */     box.NL();
/*    */     
/* 69 */     box.textLL(¤¤available);
/* 70 */     box.tab(7);
/* 71 */     box.add((SPRITE)GFORMAT.iofk(box.text(), available, total));
/* 72 */     box.NL();
/*    */     
/* 74 */     box.textLL(Dic.¤¤Total);
/* 75 */     box.tab(7);
/* 76 */     box.add((SPRITE)GFORMAT.iofk(box.text(), this.b.stations.available(), this.b.stations.total()));
/* 77 */     box.NL();
/*    */     
/* 79 */     if ((S.get()).developer)
/* 80 */       for (int i = 0; i < this.states.length; i++) {
/* 81 */         box.add((SPRITE)box.text().add(i).add(':'));
/* 82 */         box.add((SPRITE)box.text().add(this.states[i]));
/* 83 */         box.NL();
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */