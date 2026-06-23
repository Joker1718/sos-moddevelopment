/*    */ package init.type;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import init.structure.STRUCTURES;
/*    */ import init.structure.Structure;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ 
/*    */ public final class BUILDING_PREFS
/*    */ {
/*    */   private static BUILDING_PREFS self;
/*    */   private final BUILDING_PREF MOUNTAIN;
/*    */   private final BUILDING_PREF OUTDOORS;
/*    */   private final LIST<BUILDING_PREF> BUILDING;
/*    */   private final LIST<BUILDING_PREF> ALL;
/*    */   private final RMAP<BUILDING_PREF> map;
/*    */   
/*    */   BUILDING_PREFS() {
/* 26 */     self = this;
/* 27 */     LinkedList<BUILDING_PREF> all = new LinkedList();
/* 28 */     this.MOUNTAIN = new BUILDING_PREF("_MOUNTAIN", (LISTE)all)
/*    */       {
/*    */         public SPRITE icon() {
/* 31 */           return (SETT.TERRAIN()).MOUNTAIN.getIcon();
/*    */         }
/*    */       };
/* 34 */     this.OUTDOORS = new BUILDING_PREF("_OUTDOORS", (LISTE)all)
/*    */       {
/*    */         public SPRITE icon() {
/* 37 */           return ((CLIMATE)CLIMATES.ALL().get(CLIMATES.ALL().size() / 2)).icon;
/*    */         }
/*    */       };
/* 40 */     LinkedList<String> keys = new LinkedList();
/* 41 */     keys.add("_MUD");
/* 42 */     keys.add((Object[])PATHS.INIT_SETTLEMENT().getFolder("structure").getFiles());
/* 43 */     ArrayList<BUILDING_PREF> buildings = new ArrayList(keys.size());
/* 44 */     int in = 0;
/* 45 */     for (String k : keys) {
/* 46 */       final int ind = in++;
/* 47 */       buildings.add(new BUILDING_PREF(k, (LISTE)all)
/*    */           {
/*    */             public SPRITE icon()
/*    */             {
/* 51 */               return ((SETT.TERRAIN()).BUILDINGS.get((Structure)STRUCTURES.all().get(ind))).iconCombo;
/*    */             }
/*    */           });
/*    */     } 
/*    */     
/* 56 */     this.BUILDING = (LIST<BUILDING_PREF>)buildings;
/* 57 */     this.ALL = (LIST<BUILDING_PREF>)new ArrayList((Iterable)all);
/*    */     
/* 59 */     this.map = new RMAP("STRUCTURE", this.ALL);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static BUILDING_PREF get(int tx, int ty) {
/* 65 */     if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty))
/* 66 */       return self.MOUNTAIN; 
/* 67 */     if (SETT.TERRAIN().get(tx, ty) instanceof TBuilding.BuildingComponent) {
/* 68 */       return (BUILDING_PREF)self.BUILDING.get((((TBuilding.BuildingComponent)SETT.TERRAIN().get(tx, ty)).building()).structure.index());
/*    */     }
/* 70 */     return self.OUTDOORS;
/*    */   }
/*    */   
/*    */   public static BUILDING_PREF get(Structure building) {
/* 74 */     return (BUILDING_PREF)self.BUILDING.get(building.index());
/*    */   }
/*    */   
/*    */   public static RMAP<BUILDING_PREF> MAP() {
/* 78 */     return self.map;
/*    */   }
/*    */   
/*    */   public static LIST<BUILDING_PREF> ALL() {
/* 82 */     return self.ALL;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\BUILDING_PREFS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */