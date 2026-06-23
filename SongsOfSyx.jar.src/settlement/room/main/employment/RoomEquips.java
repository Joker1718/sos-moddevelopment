/*    */ package settlement.room.main.employment;
/*    */ 
/*    */ import game.boosting.Boostable;
/*    */ import game.boosting.BoostableCat;
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import init.sprite.UI.UI;
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.ROOMS;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.Dic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RoomEquips
/*    */ {
/*    */   public final LIST<RoomEquip> ALL;
/*    */   private final ArrayList<ArrayListGrower<RoomEquip>> perRoom;
/*    */   
/*    */   RoomEquips(ROOMS rooms, RoomEmployments emps) {
/* 28 */     BoostableCat cat = new BoostableCat("EQUIP_", Dic.¤¤Equipment, Dic.¤¤Equipment, 1, (SPRITE)(UI.icons()).s.house);
/* 29 */     ArrayListGrower<RoomEquip> all = new ArrayListGrower();
/*    */     
/* 31 */     PATH p = PATHS.INIT().getFolder("resource").getFolder("work"); byte b; int i;
/*    */     String[] arrayOfString;
/* 33 */     for (i = (arrayOfString = p.getFiles()).length, b = 0; b < i; ) { String k = arrayOfString[b]; b++; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 39 */     this.ALL = (LIST<RoomEquip>)all;
/*    */     
/* 41 */     this.perRoom = new ArrayList(emps.ALLS().size());
/* 42 */     while (this.perRoom.hasRoom()) {
/* 43 */       this.perRoom.add(new ArrayListGrower());
/*    */     }
/*    */     
/* 46 */     for (RoomEquip t : all) {
/* 47 */       for (RoomEmploymentSimple e : emps.ALLS()) {
/* 48 */         if ((t.target(e)).max > 0) {
/* 49 */           ((ArrayListGrower)this.perRoom.get(e.eindex())).add(t);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RoomEquip.Target boostToTarget(Boostable bo) {
/* 58 */     if (bo.index() >= ((RoomEquip.Target)RoomEquip.Target.boos.get(0)).boost().index() && bo.index() < ((RoomEquip.Target)RoomEquip.Target.boos.get(RoomEquip.Target.boos.size() - 1)).boost().index()) {
/* 59 */       return (RoomEquip.Target)RoomEquip.Target.boos.get(bo.index() - ((RoomEquip.Target)RoomEquip.Target.boos.get(0)).boost().index());
/*    */     }
/* 61 */     return null;
/*    */   }
/*    */   
/*    */   public LIST<RoomEquip> get(RoomEmploymentSimple e) {
/* 65 */     return (LIST<RoomEquip>)this.perRoom.get(e.eindex());
/*    */   }
/*    */   
/* 68 */   final SAVABLE saver = new SAVABLE()
/*    */     {
/*    */       public void save(FilePutter file)
/*    */       {
/* 72 */         file.i(RoomEquips.this.ALL.size());
/* 73 */         for (RoomEquip t : RoomEquips.this.ALL) {
/* 74 */           t.saver.save(file);
/*    */         }
/*    */       }
/*    */       
/*    */       public void load(FileGetter file) throws IOException {
/* 79 */         int am = file.i();
/*    */         
/* 81 */         if (am != RoomEquips.this.ALL.size()) {
/* 82 */           for (int i = 0; i < am; i++) {
/* 83 */             ((RoomEquip)RoomEquips.this.ALL.get(0)).saver.load(file);
/*    */           }
/* 85 */           clear();
/*    */         } else {
/* 87 */           for (RoomEquip t : RoomEquips.this.ALL) {
/* 88 */             t.saver.load(file);
/*    */           }
/*    */         } 
/*    */       }
/*    */ 
/*    */       
/*    */       public void clear() {
/* 95 */         for (RoomEquip t : RoomEquips.this.ALL)
/* 96 */           t.saver.clear(); 
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEquips.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */