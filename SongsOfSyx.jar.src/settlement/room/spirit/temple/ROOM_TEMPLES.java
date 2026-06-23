/*    */ package settlement.room.spirit.temple;
/*    */ 
/*    */ import init.religion.RELIGIONS;
/*    */ import init.religion.Religion;
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.ROOMS;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.main.util.RoomsCreator;
/*    */ import settlement.room.spirit.shrine.ROOM_SHRINE;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ public final class ROOM_TEMPLES
/*    */ {
/*    */   public final LIST<ROOM_TEMPLE> ALL;
/*    */   public final LIST<ROOM_SHRINE> SHRINES;
/*    */   public final LIST<LIST<ROOM_TEMPLE>> perRel;
/*    */   public final LIST<LIST<ROOM_SHRINE>> perRelShrine;
/*    */   
/*    */   public ROOM_TEMPLES(ROOMS rooms, final RoomInitData init) throws IOException {
/* 25 */     this.ALL = (new RoomsCreator<ROOM_TEMPLE>(init, "TEMPLE", 
/* 26 */         rooms.CATS.SER_REL)
/*    */       {
/*    */         public ROOM_TEMPLE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*    */         {
/* 30 */           return new ROOM_TEMPLE(index, data, key, cat);
/*    */         }
/* 33 */       }).all();
/*    */     
/* 35 */     this.SHRINES = (new RoomsCreator<ROOM_SHRINE>(init, "SHRINE", 
/* 36 */         rooms.CATS.SER_REL)
/*    */       {
/*    */         public ROOM_SHRINE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*    */         {
/* 40 */           return new ROOM_SHRINE(key, index, init, cat);
/*    */         }
/* 43 */       }).all();
/*    */     
/* 45 */     ArrayList<LIST<ROOM_TEMPLE>> arrayList = new ArrayList(RELIGIONS.ALL().size());
/*    */     
/* 47 */     for (Religion rel : RELIGIONS.ALL()) {
/* 48 */       ArrayListGrower<ROOM_TEMPLE> res = new ArrayListGrower();
/* 49 */       for (ROOM_TEMPLE t : this.ALL) {
/* 50 */         if (t.religion == rel)
/* 51 */           res.add(t); 
/*    */       } 
/* 53 */       arrayList.add(res);
/*    */     } 
/* 55 */     this.perRel = (LIST<LIST<ROOM_TEMPLE>>)arrayList;
/*    */ 
/*    */     
/* 58 */     ArrayList<LIST<ROOM_SHRINE>> tt = new ArrayList(RELIGIONS.ALL().size());
/*    */     
/* 60 */     for (Religion rel : RELIGIONS.ALL()) {
/* 61 */       ArrayListGrower<ROOM_SHRINE> res = new ArrayListGrower();
/* 62 */       for (ROOM_SHRINE t : this.SHRINES) {
/* 63 */         if (t.religion == rel)
/* 64 */           res.add(t); 
/*    */       } 
/* 66 */       tt.add(res);
/*    */     } 
/*    */ 
/*    */     
/* 70 */     this.perRelShrine = (LIST<LIST<ROOM_SHRINE>>)tt;
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<ROOM_TEMPLE> temples(Religion rel) {
/* 75 */     return (LIST<ROOM_TEMPLE>)this.perRel.get(rel.index());
/*    */   }
/*    */   
/*    */   public LIST<ROOM_SHRINE> shrines(Religion rel) {
/* 79 */     return (LIST<ROOM_SHRINE>)this.perRelShrine.get(rel.index());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\ROOM_TEMPLES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */