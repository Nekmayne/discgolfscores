package haagahelia.discgolfscores.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import haagahelia.discgolfscores.domain.Course;
import haagahelia.discgolfscores.domain.CourseRepository;

@Controller
public class ScoreController {

	@Autowired
	private CourseRepository repository;

	@RequestMapping("/courselist")
	public String scorelist(Model model) {
		model.addAttribute("courses", repository.findAll());
		return "courselist";
	}

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public @ResponseBody List<Course> courseListRest() {
		return (List<Course>) repository.findAll();
	}

	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Course> findCourseRest(@PathVariable("id") Long courseId) {
		return repository.findById(courseId);

	}

	@RequestMapping(value = "/addcourse")
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		return "addcourse";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Course course) {
		repository.save(course);
		return "redirect:courselist";

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCourse(@PathVariable("id") Long courseId, Model model) {
		repository.deleteById(courseId);
		return "redirect:../courselist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCourse(@PathVariable("id") Long courseId, Model model) {
		model.addAttribute("course", repository.findById(courseId));
		return "editcourse";
	}

	@RequestMapping(value = { "/login", "/" })
	public String login() {
		return "login";
	}

}
