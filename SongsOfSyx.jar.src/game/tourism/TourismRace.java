/*    */ package game.tourism;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import init.race.Race;
/*    */ import java.util.Comparator;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TourismRace
/*    */ {
/* 20 */   private static final KeyMap<Text> cache = new KeyMap();
/* 21 */   private static final Text DUMMY = new Text(null);
/*    */   
/*    */   public final double occurence;
/*    */   
/*    */   public final double credits;
/*    */   
/*    */   final Text data;
/*    */   public final LIST<RoomBlueprintIns<?>> attractions;
/*    */   
/*    */   public TourismRace(Json json, final Race race) {
/* 31 */     if (json.has("TOURIST")) {
/* 32 */       json = json.json("TOURIST");
/* 33 */       this.occurence = json.d("OCCURENCE", 0.0D, 100000.0D);
/* 34 */       this.credits = json.d("CREDITS", 0.0D, 100000.0D);
/* 35 */       String d = json.value("TOURIST_TEXT_FILE");
/* 36 */       if (!cache.containsKey(d)) {
/* 37 */         cache.put(d, new Text(new Json(PATHS.TEXT().getFolder("race").getFolder("tourist").gets(d))));
/*    */       }
/* 39 */       this.data = (Text)cache.get(d);
/*    */     } else {
/* 41 */       this.data = DUMMY;
/* 42 */       this.occurence = 0.0D;
/* 43 */       this.credits = 0.0D;
/*    */     } 
/*    */ 
/*    */     
/* 47 */     ArrayListGrower<RoomBlueprintImp> li = new ArrayListGrower();
/* 48 */     for (RoomBlueprintImp b : (SETT.ROOMS()).bonus.all) {
/* 49 */       if (b.employment() != null && race.pref().getWork(b.employment()) > 0.0D) {
/* 50 */         li.add(b);
/*    */       }
/*    */     } 
/*    */     
/* 54 */     li.sort(new Comparator<RoomBlueprintImp>()
/*    */         {
/*    */           public int compare(RoomBlueprintImp o1, RoomBlueprintImp o2)
/*    */           {
/* 58 */             double v = race.pref().getWork(o1.employment()) - race.pref().getWork(o2.employment());
/* 59 */             if (v < 0.0D)
/* 60 */               return 1; 
/* 61 */             if (v > 0.0D)
/* 62 */               return -1; 
/* 63 */             return 0;
/*    */           }
/*    */         });
/*    */     
/* 67 */     int am = Math.min(li.size(), 5);
/* 68 */     ArrayList<RoomBlueprintIns<?>> res = new ArrayList(am);
/* 69 */     for (RoomBlueprint b : li) {
/* 70 */       res.add(b);
/* 71 */       if (!res.hasRoom()) {
/*    */         break;
/*    */       }
/*    */     } 
/*    */     
/* 76 */     this.attractions = (LIST<RoomBlueprintIns<?>>)res;
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomBlueprintIns<?> getAttraction(long ran) {
/* 81 */     return (RoomBlueprintIns)this.attractions.getC((int)ran);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\TourismRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */