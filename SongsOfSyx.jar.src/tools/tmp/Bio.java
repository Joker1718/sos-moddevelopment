/*     */ package tools.tmp;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Collectors;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ public class Bio
/*     */ {
/*  16 */   private static KeyMap<String> tmp = new KeyMap();
/*     */ 
/*     */   
/*     */   public static void main(String[] args) throws IOException {
/*  20 */     File root = new File("C:\\Users\\jakob\\Desktop\\jakob\\syx\\code\\syx71\\Syx\\zipdata\\data\\assets\\init\\player\\titles");
/*     */     
/*  22 */     Iterator<Path> it = Files.list(root.toPath()).iterator();
/*  23 */     while (it.hasNext()) {
/*     */       
/*  25 */       Path p = it.next();
/*     */       
/*  27 */       Json jj = new Json(p);
/*     */       
/*  29 */       int j = jj.i("ICON_I");
/*     */       
/*  31 */       if (tmp.containsKey("" + j)) {
/*  32 */         System.out.println((String)tmp.get("" + j) + " -> " + (String)tmp.get("" + j));
/*     */       } else {
/*  34 */         tmp.put("" + j, String.valueOf(p.getFileName()));
/*     */       } 
/*  36 */       System.out.println(p.getFileName());
/*     */     } 
/*     */ 
/*     */     
/*  40 */     String pp = "INCOMPETENT\r\nThe Provider\r\nProduce a lot of stuff natively.\r\nClient\t\t\t\t\r\nBUREAUCRAT\r\nThe Bureaucrat\r\nGained by having your papers in order. Increases admin.\r\nClient\t\t\t\t\r\nCARETAKER\r\nThe Caretaker\r\nGained by having proper access to hospitals. Increases health.\r\nClient\t\t\t\t\r\nCLUMSY\r\nThe Clumsy\r\nGained by living through multiple accidents. Makes people a bit more cautious in your presence.\r\nClient\t\t\t\t\r\nDRUNKARD\r\nThe Drunkard\r\nGained by having lots of drunk subjects. Increases drink production.\r\nClient\t\t\t\t\r\nENTERTAINER\r\nThe Entertainer\r\nGained by having good access to entertainment and repeatedly shouting 'Are you not entertained?' at the screen. Increases happiness.\r\nClient\t\t\t\t\r\nGOURMAND\r\nThe Gourmand\r\nGained by having lots of food. Increases food production.\r\nClient\t\t\t\t\r\nMERCIFUL\r\nThe Merciful\r\nGained by being a saint after battles. Adds some loyalty to your name.\r\nClient\t\t\t\t\r\nMERCILESS\r\nThe merciless\r\nGained by being harsh on your conquered foes. Slaves will be more easily controlled.\r\nClient\t\t\t\t\r\nPLEASURER\r\nThe Pleasurer\r\nGained by having good access to Massage Parlour. Increases happiness.\r\nClient\t\t\t\t\r\nUNDEFEATED\r\nThe Undefeated\r\nGained by being a badass on the field of battle. Increases morale and detriments raids.\r\nClient\t\t\t\t\r\nUNITER\r\nThe Uniter\r\nGained by absorbing a lot of kingdoms.\r\nClient\t\t\t\t\r\nWISE\r\nThe Wise\r\nGained by being a knowledge nerd. Increases knowledge and education rates.\r\nClient\t\t\t\t\r\nARTISAN\r\nThe Artisan\r\nGained by workshop output. Increases productivity of all workshops.\r\nClient\t\t\t\t\r\nBREAKER_OF_CHAINS\r\nBreaker of Chains\r\nGained by freeing many slaves.\r\nClient\t\t\t\t\r\nCHILD_OF_THE_SUN\r\nThe Child of the Sun\r\nHave loads of farms and orchards.\r\nClient\t\t\t\t\r\nFIRST_NAME\r\nFirst of Their Name\r\nGained by having 1500 happy people and increases your starting population and supplies of new games.\r\nClient\t\t\t\t\r\nHEAVIEST_OF_HANDS\r\nHeaviest of Hands\r\nGained by a lot of executions. Increases law.\r\nClient\t\t\t\t\r\nHERDER\r\nHerdsman of Entelodonts\r\nHave loads of Entelodont pastures.\r\nClient\t\t\t\t\r\nLIFE_BRINGER\r\nLifebringer\r\nCure a lot of people in the hospital.\r\nClient\t\t\t\t\r\nLORD_SEVEN\r\nLord of the Seven Kingdoms\r\nControl 7 regions to gain this ancient and prestigious title.\r\nClient\t\t\t\t\r\nRICHEST_OF_KINGS\r\nRichest of Kings\r\nDecreases inflation, allowing you to amass even greater wealth.\r\nClient\t\t\t\t\r\nRULER_OF_COLD\r\nWarden of the North\r\nSurvive and thrive in a cold climate to gain the goodwill of its hardened people.\r\nClient\t\t\t\t\r\nRULER_OF_HOT\r\nRuler of Sedge and Bee\r\nSurvive and thrive in a hot climate to gain the goodwill of its hardened people.\r\nClient\t\t\t\t\r\nSEER_OF_THE_GODS\r\nSeer of the Gods\r\nA ruler making his people pay homage to the spiritual realm. Surely the gods reward such piety.\r\nClient\t\t\t\t\r\nTHE_BUILDER\r\nThe Builder\r\nBuild a bunch of fancy buildings on the world map.\r\nClient\t\t\t\t\r\nTHE_CONQUERER\r\nThe Conquerer\r\nGained by killing your enemies.\r\nClient\t\t\t\t\r\nTHE_GREAT\r\nThe Great\r\nGained by having many people follow and love you.\r\nClient\t\t\t\t\r\nTHE_MAD\r\nThe Mad\r\nHave a bunch of insane people running around in your city.\r\nClient\t\t\t\t\r\nTHE_NUDIST\r\nThe Nudist\r\nKeep your citizens naked, and gain an extra boost to exposure.\r\nClient\t\t\t\t\r\nTHE_RAIDED\r\nProtector of the Realm\r\nGained by defending against invasions.\r\nClient\t\t\t\t\r\nTHE_SLAVER\r\nThe Slaver\r\nGained by having many slaves.\r\nClient\t\t\t\t\r\nTHE_USURPER\r\nThe Usurper\r\nKill a couple of foreign royalties to gain this lucrative title.\r\nClient\t\t\t\t\r\nRULER_OF_RULER\r\nRuler of Kings\r\nA master of Syx, a title only granted to the greats.";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     List<String> ll = pp.lines().collect((Collector)Collectors.toList());
/*     */     
/* 178 */     KeyMap<Entry> ees = new KeyMap();
/*     */     
/* 180 */     for (int i = 0; i < ll.size(); i++) {
/* 181 */       String l = ll.get(i);
/* 182 */       if (!l.startsWith("Client")) {
/*     */         
/* 184 */         Entry e = new Entry();
/* 185 */         e.key = ll.get(i++);
/* 186 */         e.name = ll.get(i++);
/* 187 */         e.desc = ll.get(i++);
/* 188 */         ees.put(e.key, e);
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     root = new File("C:\\Users\\jakob\\Desktop\\jakob\\syx\\code\\syx71\\Syx\\zipdata\\data\\assets\\text\\player\\titles");
/*     */     
/* 194 */     it = Files.list(root.toPath()).iterator();
/* 195 */     while (it.hasNext()) {
/*     */       
/* 197 */       Path p = it.next();
/* 198 */       String file = String.valueOf(p.getFileName()).split(".txt")[0];
/*     */       
/* 200 */       Entry e = (Entry)ees.get(file);
/* 201 */       Json jj = new Json(p);
/*     */       
/* 203 */       if (!e.name.equalsIgnoreCase(jj.text("NAME"))) {
/* 204 */         System.out.println(file + " " + file + " " + e.name);
/*     */       }
/* 206 */       if (!e.desc.equalsIgnoreCase(jj.text("DESC"))) {
/* 207 */         System.out.println(file);
/* 208 */         System.out.println(e.desc);
/* 209 */         System.out.println(jj.text("DESC"));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class Entry {
/*     */     String key;
/*     */     String name;
/*     */     String desc;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\tmp\Bio.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */